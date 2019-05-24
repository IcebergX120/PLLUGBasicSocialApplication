package com.example.basicsocialapplication.ui.authorization;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.basicsocialapplication.R;

public class AboutFragment extends Fragment {

    private View v;
    private TextView author;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.about_fragment, container, false);

        author = v.findViewById(R.id.author);

        return  v;
    }

}
