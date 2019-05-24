package com.example.basicsocialapplication.ui.main.todo.model.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.basicsocialapplication.ui.main.todo.model.network.Todo;

import java.util.List;
import java.util.Observable;

import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;

@Dao
public interface TodoDao {

    @Query("SELECT * FROM todo")
    Flowable<List<Todo>> getAllUsers();

    @Insert
    void insert(Todo todo);

    @Insert
    void insert(List<Todo> todos);

}
