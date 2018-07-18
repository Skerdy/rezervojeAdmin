package com.rsb.rezervojeadmin.Retrofit.RequestsAPI;

import com.rsb.rezervojeadmin.Models.BodyModels.UserCredentials;
import com.rsb.rezervojeadmin.Models.ResponseModels.LoginResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface BasicApi {

    @Headers({"Content-Type:application/json"})
    @POST("login")
    Call<LoginResponse> login(@Body UserCredentials userCredentials);

}
