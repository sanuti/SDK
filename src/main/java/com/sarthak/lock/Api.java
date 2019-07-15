package com.sarthak.lock;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @FormUrlEncoded
    @GET("lock_update.php")
    Call<String> update_lock(@Query("lock") String lock, @Query("status")String status );
}
