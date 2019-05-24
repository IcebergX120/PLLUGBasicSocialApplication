package com.example.basicsocialapplication.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.basicsocialapplication.R;
import com.example.basicsocialapplication.model.Album;
import com.example.basicsocialapplication.model.Post;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

    private List<Album> albumList;
    private Context context;

    public AlbumAdapter(List<Album> albumList, Context context) {
        this.albumList = albumList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_album, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.item_album_id.setText(String.valueOf(albumList.get(position).getId()));
        holder.item_album_title.setText(albumList.get(position).getTitle());


    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView item_album_title, item_album_id;

        public ViewHolder(View view) {
            super(view);

            item_album_title = itemView.findViewById(R.id.item_album_title);
            item_album_id = itemView.findViewById(R.id.item_album_id);
        }
    }
}
