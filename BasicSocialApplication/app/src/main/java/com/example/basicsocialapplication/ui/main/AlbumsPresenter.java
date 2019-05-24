package com.example.basicsocialapplication.ui.main;

import android.content.Context;

import com.example.basicsocialapplication.api.ApiClient;
import com.example.basicsocialapplication.api.ApiInterface;
import com.example.basicsocialapplication.model.Album;
import com.example.basicsocialapplication.ui.adapter.AlbumAdapter;
import com.example.basicsocialapplication.utill.JSONParser;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumsPresenter {

    private List<Album> albumList = new ArrayList<>();
    private AlbumAdapter adapter;
    private IMainView iAlbumView;
    private Context context;

    private String responseBody;

    public AlbumsPresenter (IMainView iAlbumView, Context context){
        this.iAlbumView = iAlbumView;
        this.context = context;
    }

    public void loadData() {
        ApiInterface apiInterface = ApiClient.getApiClient();

        Call<JsonArray> call = apiInterface.getAlbums();

        call.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                responseBody = response.body().toString();

                Type type = new TypeToken<ArrayList<Album>>() {}.getType();
                ArrayList<Album> arrayList = JSONParser.getFromJSONtoArrayList(responseBody, type);
                albumList = arrayList;

                adapter = new AlbumAdapter(albumList, context);

                iAlbumView.setAdapter(adapter);

                iAlbumView.hideRefreshing();
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {

            }
        });
    }

}