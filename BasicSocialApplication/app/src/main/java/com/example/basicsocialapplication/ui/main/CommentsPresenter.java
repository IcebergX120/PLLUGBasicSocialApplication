package com.example.basicsocialapplication.ui.main;

import android.content.Context;

import com.example.basicsocialapplication.api.ApiClient;
import com.example.basicsocialapplication.api.ApiInterface;
import com.example.basicsocialapplication.model.Comment;
import com.example.basicsocialapplication.ui.adapter.CommentAdapter;
import com.example.basicsocialapplication.utill.JSONParser;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentsPresenter {

    private List<Comment> commentList = new ArrayList<>();
    private CommentAdapter adapter;
    private IMainView iCommentView;
    private Context context;

    private String responseBody;

    public CommentsPresenter (IMainView iCommentView, Context context){
        this.iCommentView = iCommentView;
        this.context = context;
    }

    public void loadData(int postId) {
        ApiInterface apiInterface = ApiClient.getApiClient();

        Call<JsonArray> call = apiInterface.getCommentsById(String.valueOf(postId));

        call.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                responseBody = response.body().toString();

                Type type = new TypeToken<ArrayList<Comment>>() {}.getType();
                ArrayList<Comment> arrayList = JSONParser.getFromJSONtoArrayList(responseBody, type);
                commentList = arrayList;

                adapter = new CommentAdapter(commentList, context);

                iCommentView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {

            }
        });
    }
}
