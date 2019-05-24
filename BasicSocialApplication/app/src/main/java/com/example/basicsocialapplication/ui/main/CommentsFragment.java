package com.example.basicsocialapplication.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.basicsocialapplication.R;
import com.example.basicsocialapplication.model.Post;

public class CommentsFragment extends Fragment implements IMainView{

    private View v;
    private Context context;

    private RecyclerView recyclerView;

    public CommentsPresenter commentsPresenter;
    private Post post;

    private TextView item_comment_name, item_comment_body;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.comments_fragment, container, false);
        context = v.getContext();

        initView();
        initPresenter();

        return v;
    }

    public void initView() {
        item_comment_name = v.findViewById(R.id.item_full_post_author);
        item_comment_body = v.findViewById(R.id.item_full_post_body_tv);

        recyclerView = v.findViewById(R.id.comments_rv);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void setPost (Post post){
        this.post = post;
        commentsPresenter.loadData(post.getId());
    }

    public void initPresenter() {
        commentsPresenter = new CommentsPresenter(this, context);
    }

    @Override
    public void hideRefreshing() {

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
