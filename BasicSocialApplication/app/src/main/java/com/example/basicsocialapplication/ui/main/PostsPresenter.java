package com.example.basicsocialapplication.ui.main;

import android.content.Context;

import com.example.basicsocialapplication.api.ApiClient;
import com.example.basicsocialapplication.api.ApiInterface;
import com.example.basicsocialapplication.model.Post;
import com.example.basicsocialapplication.ui.adapter.PostAdapter;
import com.example.basicsocialapplication.utill.JSONParser;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsPresenter {

    private List<Post> postList = new ArrayList<>();
    private PostAdapter adapter;
    private IMainView iPostView;
    private Context context;

    private String responseBody;

    public PostsPresenter (IMainView iPostView, Context context){
        this.iPostView = iPostView;
        this.context = context;
    }

    public void loadData() {
        ApiInterface apiInterface = ApiClient.getApiClient();

        Call<JsonArray> call = apiInterface.getPosts();

        call.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                responseBody = response.body().toString();

                Type type = new TypeToken<ArrayList<Post>>() {}.getType();
                ArrayList<Post> arrayList = JSONParser.getFromJSONtoArrayList(responseBody, type);
                postList = arrayList;

                adapter = new PostAdapter(postList, context);

                iPostView.setAdapter(adapter);

                iPostView.hideRefreshing();
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {

            }
        });
    }

}
