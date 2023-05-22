package com.AlexUtils;

import android.app.Application;
import android.content.Context;

import androidx.constraintlayout.utils.widget.MockView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;



// Abandoned Volley Test
// this import kept failing and I couldn't get it working. Sad.
//
// import android.net.http.AndroidHttpClient;
// Project View -> External Libraries -> Gradle: com.android.volley:volley -> toolbox -> Volley.class


public class AlexUtils {
    String jsonResponse ="";

    public RequestQueue queue;

    public AlexUtils(Context context){
         queue = Volley.newRequestQueue(context);
    }

    public StringRequest apiQueryTestMethod(){

        String url = "https://run.mocky.io/v3/077aa56d-6acf-4da2-9f08-8cb52c94f1f1";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.

                        jsonResponse = response;
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //dont know
            }
        });

        return stringRequest;
    }

    // Add the request to the RequestQueue.

    public void addToResponseQueue(StringRequest request, RequestQueue requestQueue){
        requestQueue.add(request);
    }
}
