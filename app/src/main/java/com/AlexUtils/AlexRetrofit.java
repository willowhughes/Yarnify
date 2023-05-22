package com.AlexUtils;

import com.AlexUtils.my_interface.GetNoticeDataService;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AlexRetrofit {

    public AlexRetrofit(){

    }


    public AlexModel Retrofitcall() {
        AlexModel testModel = new AlexModel("test");
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io/v32/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        GetNoticeDataService service = retrofit.create(GetNoticeDataService.class);

        // Calling '/api/users/2'
        Call<AlexModel> callSync = service.getPattern("3859b8db-08aa-4bf1-a76e-2d8066bd2ac3");

        try {
            Response<AlexModel> response = callSync.execute();
            AlexModel apiResponse = response.body();
            testModel = apiResponse;
            System.out.println(apiResponse);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return testModel;

    }
}
