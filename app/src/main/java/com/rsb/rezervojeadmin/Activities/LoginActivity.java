package com.rsb.rezervojeadmin.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rsb.rezervojeadmin.Models.BodyModels.UserCredentials;
import com.rsb.rezervojeadmin.Models.ResponseModels.LoginResponse;
import com.rsb.rezervojeadmin.R;
import com.rsb.rezervojeadmin.Retrofit.RequestsAPI.BasicApi;
import com.rsb.rezervojeadmin.Retrofit.RetrofitClient;
import com.rsb.rezervojeadmin.Utils.ResponseUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;



public class LoginActivity extends AppCompatActivity {

    private String email, password;
    private EditText emailEt, passwordEt;
    private Button loginButton;
    private ProgressDialog progressDialog;
    private RetrofitClient retrofitClient;
    private BasicApi basicApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        retrofitClient = new RetrofitClient();
        basicApi = retrofitClient.krijoBasicApi();
        setupViews();
    }

    private void setupViews(){

        loginButton = findViewById(R.id.login_Button);
        emailEt = findViewById(R.id.email);
        passwordEt = findViewById(R.id.password);
        progressDialog= new ProgressDialog(this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                if(validate()){
                    basicApi.login(new UserCredentials(email, password)).enqueue(loginCallBack);
                }
                else {
                    progressDialog.dismiss();
                }
            }
        });
    }


    private boolean validate(){

        email = emailEt.getText().toString();
        password = passwordEt.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEt.setError("Enter a valid email address!");
            return false;
        } else {
            emailEt.setError(null);
        }

        if (password.isEmpty() || password.length() < 3 || password.length() > 30) {
            passwordEt.setError("Password must be between 3 and 30 characters");
            return false;
        } else {
            passwordEt.setError(null);
        }

        return  true;
    }

    private void loginSuccess(){
        Intent  intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    Callback<LoginResponse> loginCallBack = new Callback<LoginResponse>() {

        @Override
        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
            progressDialog.dismiss();
           if( ResponseUtils.responseSuccess(response)){
                progressDialog.dismiss();
                loginSuccess();
           }
           else {
               Toast.makeText(LoginActivity.this, "Wrong Credentials, login failed!", Toast.LENGTH_LONG).show();
           }

        }

        @Override
        public void onFailure(Call<LoginResponse> call, Throwable t) {
            progressDialog.dismiss();
            ResponseUtils.logRetrofitFailure("LoginRequest", t);
        }
    };

}
