package com.example.basicsocialapplication.ui.main.todo.model.network;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class Todo {

    @SerializedName("userId")
    @Expose
    @PrimaryKey(autoGenerate = true)
    private int userId;
    @SerializedName("id")
    @Expose
    @ColumnInfo(name = "todoId")
    private int id;
    @SerializedName("title")
    @Expose
    @ColumnInfo(name = "todoTitle")
    private String title;
    @SerializedName("completed")
    @Expose
    @ColumnInfo(name = "todoCompleted")
    private boolean completed;

    public Todo(int userId, int id, String title, boolean completed) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

}