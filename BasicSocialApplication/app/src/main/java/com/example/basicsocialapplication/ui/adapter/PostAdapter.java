package com.example.basicsocialapplication.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.basicsocialapplication.R;
import com.example.basicsocialapplication.model.Post;
import com.example.basicsocialapplication.ui.main.CommentsFragment;
import com.google.gson.JsonArray;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private List<Post> postList;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public PostAdapter(List<Post> postList, Context context) {
        this.postList = postList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);

        return new ViewHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Post post = postList.get(position);

        holder.item_post_author.setText(String.valueOf(postList.get(position).getId()));
        holder.item_post_title.setText(postList.get(position).getTitle());
        holder.item_post_body.setText(postList.get(position).getBody());

        holder.item_post_see_comments_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                CommentsFragment commentsFragment = new CommentsFragment();

                FragmentManager fragmentManager =((AppCompatActivity)context).getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_main_container, commentsFragment)
                        .addToBackStack(null)
                        .commit();
                fragmentManager.executePendingTransactions();
                commentsFragment.setPost(post);
            }
        });
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final OnItemClickListener onItemClickListener;
        public TextView item_post_author, item_post_title, item_post_body;
        public Button item_post_see_comments_btn;

        public ViewHolder(View view, OnItemClickListener onItemClickListener) {
            super(view);

            view.setOnClickListener(this);

            item_post_author = itemView.findViewById(R.id.item_post_author);
            item_post_title = itemView.findViewById(R.id.item_post_title);
            item_post_body = itemView.findViewById(R.id.item_post_body);

            item_post_see_comments_btn = itemView.findViewById(R.id.item_post_see_comments_btn);

            this.onItemClickListener = onItemClickListener;
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(getAdapterPosition());
        }
    }
}
