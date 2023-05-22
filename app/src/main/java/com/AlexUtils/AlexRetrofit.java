package com.AlexUtils;

import com.AlexUtils.POJOModels.AlexPatternClassFromJSONSimple;
import com.AlexUtils.my_interface.GetNoticeDataService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



//Testing the retrofit package
public class AlexRetrofit {

    //this lets me call an instance of this class in AlexRetrofitTest
    public AlexRetrofit(){
    }

    //
    public AlexModel Retrofitcall() {

        //AlexModel is a class built as a "POJO", a "Plain Old Javascript Object"
        //It lets GSON deserialize JSON data into the class attributes
        //I create this one here so it is accessible outside
        // of the "Response" method within the query. So I can access it's values for a test at the end.
        AlexModel testModel = new AlexModel("test");

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();


        /*
        URL is using mocky.io which lets you create a custom response to a http query.
        It stores data locally though. So if you want to create a mock you can copy and paste this JSON
        and generate a mock on mocky.io.

        You'll have to change the address below to the one connected to your mock.

        It returns this JSON.
        A String called patternListClass
        and an array of JSON Objects called patternArray

           {
            "patternListClass": "This is a JSON with an array of JSON objects",
             "patternArray": [
                                {"firstJSONObjectKey": "firstJSONObjectValue"},
                                {"secondJSONObjectKey": "secondJSONObjectValue"}
                             ]
            }
        */

        Retrofit retrofit = new Retrofit.Builder()
                //this is the base of the API's Url
                .baseUrl("https://run.mocky.io/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        GetNoticeDataService service = retrofit.create(GetNoticeDataService.class);

        // this string parameter is the rest of the full Url https://run.mocky.io/v3/d6965d1a-645c-4689-a40b-32bd2520e81a
        Call<AlexModel> callSync = service.getPattern("04d967f7-f638-4777-a5bc-fe9980c92e7a");

        try {
            Response<AlexModel> response = callSync.execute();
            //this is where to do stuff with the response
            AlexModel apiResponse = response.body();
            testModel = apiResponse;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return testModel;

    }

    //this one queries Ravelry API using headers within GetNoticeDataService class
    //returning a malformed JSON at the moment idk why
    public JSONObject RetrofitRavelryVersion(){
        JSONObject testClass = new JSONObject();

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                //this is the base of the API's Url
                .baseUrl("https://api.ravelry.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient.build())
                .build();

        GetNoticeDataService service = retrofit.create(GetNoticeDataService.class);

        Call<AlexPatternClassFromJSONSimple> callSync = service.getPatternFromRav("patterns.json?ids=1335913");

        try {
            Response<AlexPatternClassFromJSONSimple> response = callSync.execute();
            //this is where to do stuff with the response
            AlexPatternClassFromJSONSimple apiResponse = response.body();
            testClass = apiResponse.getPatterns();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return testClass;
    }
}
