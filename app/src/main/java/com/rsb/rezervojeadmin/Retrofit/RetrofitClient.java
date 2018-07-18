package com.rsb.rezervojeadmin.Retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rsb.rezervojeadmin.Retrofit.RequestsAPI.BasicApi;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    Retrofit retrofit;

    public RetrofitClient() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(EndPointUtil.SERVER)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
    }

    public BasicApi krijoBasicApi(){
        return this.retrofit.create(BasicApi.class);
    }

}