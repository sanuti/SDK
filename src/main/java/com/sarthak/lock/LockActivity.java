package com.sarthak.lock;

import android.util.Base64;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class LockActivity {
    Methods methods;
    String Base_url;
    String lock;
    static Retrofit retrofit;
    public LockActivity(String base_url) {
        Base_url = base_url;
    }
    public LockActivity create() {
        retrofit=new Retrofit.Builder().baseUrl(Base_url).addConverterFactory(ScalarsConverterFactory.create()).build();
        return this;
    }
    public void LockProcess(final Methods methods) {
        Api api=retrofit.create(Api.class);
        Call<String> lock_call=api.update_lock("l1","2");
        lock_call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.body().equals("Record updated successfully")) {
                    methods.onSuccess();
                }
                else {
                    methods.onFailure();
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                methods.onFailure();
            }
        });

    }
    public void UnLockProcess(final Methods methods) {
        Api api=retrofit.create(Api.class);
        Call<String> lock_call=api.update_lock("l1","1");
        lock_call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.body().equals("Record updated successfully")) {
                    methods.onSuccess();
                }
                else {
                    methods.onFailure();
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                methods.onFailure();
            }
        });

    }

}
