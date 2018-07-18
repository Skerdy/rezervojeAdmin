package com.rsb.rezervojeadmin.Utils;

import android.util.Log;

import retrofit2.Response;


public class ResponseUtils {

    public static boolean responseSuccess(Response response){
        if(response.isSuccessful()){
            Log.d("ResponseUtil", "Response was successful");
            return true;
        }
        else{
            Log.d("ResponseUtil", "Response failed : " + response.message());
            Log.d("ResponseUtil", "Response code : " + response.code());
            return false;
        }
    }

    public static void logRetrofitFailure (String requestName, Throwable t){
            Log.d("ResponseUtil", requestName + "-> " + "OnFailure: " + t.getMessage());
    }
}
