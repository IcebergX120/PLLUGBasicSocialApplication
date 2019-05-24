package com.example.basicsocialapplication.api;

import com.example.basicsocialapplication.ui.main.todo.model.network.Todo;
import com.example.basicsocialapplication.model.User;
import com.google.gson.JsonArray;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("/users")
    Call<JsonArray> getUsers();

    @GET("/posts")
    Call<JsonArray> getPosts();

    @GET("/comments")
    Call<JsonArray> getComments();

    @GET("/posts/{postId}/comments")
    Call<JsonArray> getCommentsById(@Path("postId") String postId);

    @GET("/users/{userId}")
    Call<User> getUserById(@Path("userId") String userId);

    @GET("/albums")
    Call<JsonArray> getAlbums();

    @GET("/todos")
    Call<List<Todo>> getTodos();

}