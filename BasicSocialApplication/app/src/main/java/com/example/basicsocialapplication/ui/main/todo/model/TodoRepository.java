package com.example.basicsocialapplication.ui.main.todo.model;

import android.content.Context;

import com.example.basicsocialapplication.api.ApiClient;
import com.example.basicsocialapplication.api.ApiInterface;
import com.example.basicsocialapplication.ui.adapter.TodoAdapter;
import com.example.basicsocialapplication.ui.main.IMainView;
import com.example.basicsocialapplication.ui.main.todo.model.db.TodoDao;
import com.example.basicsocialapplication.ui.main.todo.model.network.Todo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodoRepository {

    private List<Todo> todoList = new ArrayList<>();
    private TodoAdapter adapter;
    private IMainView iTodoView;
    private Context context;
    private TodoDao todoDao;
    private CompositeDisposable disposable;

    public TodoRepository (IMainView iTodoView, TodoDao todoDao, Context context){
        this.iTodoView = iTodoView;
        this.todoDao = todoDao;
        this.context = context;
    }

    public void getPost() {
        disposable.add(todoDao.getAllUsers().observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<Todo>>() {
            @Override
            public void accept(List<Todo> it) throws Exception {
                if (it == null) {
                    loadData();
                } else {
                    adapter = new TodoAdapter(it, context);
                }
            }
        }));
    }

    public void loadData() {
        ApiInterface apiInterface = ApiClient.getApiClient();

        Call<List<Todo>> call = apiInterface.getTodos();

        call.enqueue(new Callback<List<Todo>>() {
            @Override
            public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {
                todoList = response.body();

                adapter = new TodoAdapter(todoList, context);

                iTodoView.setAdapter(adapter);

                iTodoView.hideRefreshing();

                Completable.fromAction(new Action() {
                    @Override
                    public void run() throws Exception {
                        todoDao.insert(todoList);
                    }
                }).observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe();

            }

            @Override
            public void onFailure(Call<List<Todo>> call, Throwable t) {

            }
        });
    }
}
