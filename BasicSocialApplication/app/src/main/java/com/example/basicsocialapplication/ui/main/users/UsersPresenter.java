package com.example.basicsocialapplication.ui.main.users;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.basicsocialapplication.R;
import com.example.basicsocialapplication.api.ApiClient;
import com.example.basicsocialapplication.api.ApiInterface;
import com.example.basicsocialapplication.model.User;
import com.example.basicsocialapplication.ui.adapter.UserAdapter;
import com.example.basicsocialapplication.ui.main.IMainView;
import com.example.basicsocialapplication.ui.main.ProfileFragment;
import com.example.basicsocialapplication.utill.JSONParser;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersPresenter {

    private List<User> userList = new ArrayList<>();
    private UserAdapter adapter;
    private IMainView iUserView;
    private Context context;

    private String responseBody;

    public UsersPresenter (IMainView iUserView, Context context){
        this.iUserView = iUserView;
        this.context = context;
    }

    public void loadData() {
        ApiInterface apiInterface = ApiClient.getApiClient();

        Call<JsonArray> call = apiInterface.getUsers();

        call.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                responseBody = response.body().toString();

                Type type = new TypeToken<ArrayList<User>>() {}.getType();
                ArrayList<User> arrayList = JSONParser.getFromJSONtoArrayList(responseBody, type);
                userList = arrayList;

                adapter = new UserAdapter(userList, context);

                iUserView.setAdapter(adapter);

                iUserView.hideRefreshing();

                adapter.setOnItemClickListener(new UserAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        ProfileFragment profileFragment = new ProfileFragment();

                        Bundle bundle = new Bundle();
                        bundle.putString("key", userList.get(position).getName());
                        profileFragment.setArguments(bundle);

                        FragmentManager fragmentManager =((AppCompatActivity)context).getSupportFragmentManager();
                        fragmentManager.beginTransaction()
                                .replace(R.id.fragment_main_container, profileFragment)
                                .addToBackStack(null)
                                .commit();
                    }
                });
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {

            }
        });
    }
}
