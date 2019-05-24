package com.example.basicsocialapplication.ui.main.todo.model.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.basicsocialapplication.ui.main.todo.model.network.Todo;

@Database(entities = {Todo.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract TodoDao todoDao();

}