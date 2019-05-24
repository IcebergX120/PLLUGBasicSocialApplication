package com.example.basicsocialapplication.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.basicsocialapplication.R;
import com.example.basicsocialapplication.ui.main.todo.model.network.Todo;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {

    private List<Todo> todoList;
    private Context context;

    public TodoAdapter(List<Todo> todoList, Context context) {
        this.todoList = todoList;
        this.context = context;
    }

    @NonNull
    @Override
    public TodoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_todo, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoAdapter.ViewHolder holder, int position) {
        holder.item_todo_id.setText(String.valueOf(todoList.get(position).getId()));
        holder.item_todo_completed.setText(todoList.get(position).getTitle());
        holder.item_todo_completed.setChecked(todoList.get(position).isCompleted());
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView item_todo_id;
        private CheckBox item_todo_completed;

        private ViewHolder(View view) {
            super(view);

            item_todo_id = view.findViewById(R.id.item_todo_id);

            item_todo_completed = view.findViewById(R.id.item_todo_completed);
        }
    }
}
