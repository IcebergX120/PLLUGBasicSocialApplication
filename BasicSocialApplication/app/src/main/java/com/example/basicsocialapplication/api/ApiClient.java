package com.example.basicsocialapplication.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static ApiInterface service;

    //URL
    private static final String ROOT_URL ="http://jsonplaceholder.typicode.com";


    public static ApiInterface getApiClient() {
        if (service == null) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ROOT_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            service = retrofit.create(ApiInterface.class);
        }
        return service;
    }

}