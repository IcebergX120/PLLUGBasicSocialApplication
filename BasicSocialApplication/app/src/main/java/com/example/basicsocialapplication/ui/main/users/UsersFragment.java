package com.example.basicsocialapplication.ui.main.users;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.basicsocialapplication.R;
import com.example.basicsocialapplication.ui.main.IMainView;

public class UsersFragment extends Fragment implements IMainView {

    private View v;
    private Context context;

    private RecyclerView recyclerView;

    public UsersPresenter usersPresenter;

    private SwipeRefreshLayout swipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.users_fragment, container, false);
        context = v.getContext();

        initView();
        initPresenter();

        usersPresenter.loadData();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                usersPresenter.loadData();
            }
        });

        return v;
    }

    public void initView() {
        recyclerView = v.findViewById(R.id.user_rv);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        swipeRefreshLayout = v.findViewById(R.id.swiperefresh_user);
    }

    public void initPresenter() {
        usersPresenter = new UsersPresenter(this, context);
    }

    @Override
    public void hideRefreshing() {
        if(swipeRefreshLayout !=null){
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void showNotFound() {

    }

    @Override
    public void showNotInternetConnection() {

    }

    @Override
    public void setAdapter(RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void setEnabledSearch(boolean b) {

    }
}