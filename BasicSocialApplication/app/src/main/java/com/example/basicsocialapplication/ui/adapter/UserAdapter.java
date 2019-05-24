package com.example.basicsocialapplication.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.basicsocialapplication.R;
import com.example.basicsocialapplication.model.User;
import com.example.basicsocialapplication.ui.main.CommentsFragment;
import com.example.basicsocialapplication.ui.main.ProfileFragment;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<User> userList;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public UserAdapter(List<User> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);

        return new ViewHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.item_user_name.setText(userList.get(position).getName());
        holder.item_user_id.setText(String.valueOf(userList.get(position).getId()));
        holder.item_user_email.setText(userList.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final OnItemClickListener onItemClickListener;
        public TextView item_user_name, item_user_id, item_user_email;

        public ViewHolder(View view, OnItemClickListener onItemClickListener) {
            super(view);

            view.setOnClickListener(this);
            item_user_name = view.findViewById(R.id.item_user_name);
            item_user_id = view.findViewById(R.id.item_user_id);
            item_user_email = view.findViewById(R.id.item_user_email);
            this.onItemClickListener = onItemClickListener;
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(getAdapterPosition());
        }
    }
}
