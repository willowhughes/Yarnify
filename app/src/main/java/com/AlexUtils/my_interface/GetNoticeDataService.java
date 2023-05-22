package com.AlexUtils.my_interface;

import com.AlexUtils.AlexModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetNoticeDataService {
    @GET("/v3/{id}")
    public Call<AlexModel> getPattern(@Path("id") String id);
}
