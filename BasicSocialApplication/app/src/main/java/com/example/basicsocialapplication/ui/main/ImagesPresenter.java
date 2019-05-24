package com.example.basicsocialapplication.ui.main;

import android.content.Context;

import com.example.basicsocialapplication.api.ApiClient;
import com.example.basicsocialapplication.api.ApiInterface;
import com.example.basicsocialapplication.model.Image;
import com.example.basicsocialapplication.ui.adapter.ImageAdapter;
import com.example.basicsocialapplication.utill.JSONParser;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImagesPresenter {

    private List<Image> imageList = new ArrayList<>();
    private ImageAdapter adapter;
    private IMainView iImageView;
    private Context context;

    private String responseBody;

    public ImagesPresenter (IMainView iImageView, Context context){
        this.iImageView = iImageView;
        this.context = context;
    }

    public void loadData() {
        ApiInterface apiInterface = ApiClient.getApiClient();

        Call<JsonArray> call = apiInterface.getPosts();

        call.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                responseBody = response.body().toString();

                Type type = new TypeToken<ArrayList<Image>>() {}.getType();
                ArrayList<Image> arrayList = JSONParser.getFromJSONtoArrayList(responseBody, type);
                imageList = arrayList;

                adapter = new ImageAdapter(imageList, context);

                iImageView.setAdapter(adapter);

                iImageView.hideRefreshing();
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {

            }
        });
    }
}