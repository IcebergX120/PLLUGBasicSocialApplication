package com.example.basicsocialapplication.ui.main;

import android.support.v7.widget.RecyclerView;

public interface IMainView {

    void hideRefreshing();

    void showNotFound();

    void showNotInternetConnection();

    void setAdapter(RecyclerView.Adapter adapter);

    void setEnabledSearch(boolean b);

}
