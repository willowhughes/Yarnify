package com.AlexUtils.my_interface;

import com.AlexUtils.AlexModel;
import com.AlexUtils.POJOModels.AlexPatternClassFromJSON;
import com.AlexUtils.POJOModels.AlexPatternClassFromJSONSimple;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;


//This is the interface to Retrofit calls
//Pretty sure this is where to add headers for basic Auth
public interface GetNoticeDataService {
    @GET("/v3/{id}")
    public Call<AlexModel> getPattern(@Path("id") String id);

    @Headers({"Authorization: Basic cmVhZC1lZTgzYjdmMWNlMmE0ZjQ1YWFmOGQxYTkwNzUwMGM2ZDpWWUFRc0M4VTYyN1ZUNUl1UHY5eS9ZdVFEVWJIUVpTL1h0aXFJNVRi",
            "Cookie: ravelrys_pocketses=eyJzZXNzaW9uX2lkIjoiOTgyNGRjZjZhN2Q1NmEzYmU4NmZiZDAwZjI0MjY4NGQiLCJfY3NyZl90b2tlbiI6InFaMlNsQmlMVWtsc0h4Vkx2c0pPQUFWcWVrUXdxMzhicVpWOFpQU0VRbEU9In0%3D--35f2bd3c7c52032a0d378a78ff2c703d0a2ad47a"})
    @GET("/{id}")
    public Call<AlexPatternClassFromJSONSimple> getPatternFromRav(@Path("id") String id);
}
