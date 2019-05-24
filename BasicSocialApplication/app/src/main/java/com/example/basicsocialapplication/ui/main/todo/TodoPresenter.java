package com.example.basicsocialapplication.ui.main.todo;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.basicsocialapplication.ui.main.todo.model.TodoRepository;
import com.example.basicsocialapplication.ui.main.todo.model.db.AppDatabase;
import com.example.basicsocialapplication.ui.main.todo.model.network.Todo;
import com.example.basicsocialapplication.ui.adapter.TodoAdapter;
import com.example.basicsocialapplication.ui.main.IMainView;

import java.util.ArrayList;
import java.util.List;

public class TodoPresenter {

    private AppDatabase todoDb;
    private TodoRepository todoRepository;
    private List<Todo> todoList = new ArrayList<>();
    private TodoAdapter adapter;
    private IMainView iTodoView;
    private Context context;

    public TodoPresenter(IMainView iTodoView, Context context) {
        this.iTodoView = iTodoView;
        this.context = context;

        todoDb = Room.databaseBuilder(context, AppDatabase.class, "todoDb").build();

        initRepository();
    }

    public void initRepository() {
        todoRepository = new TodoRepository(iTodoView, todoDb.todoDao(), context);
    }

    public void getTodo() {
        todoRepository.loadData();
    }

    public AppDatabase getTodoDb() {
        return todoDb;
    }
}
