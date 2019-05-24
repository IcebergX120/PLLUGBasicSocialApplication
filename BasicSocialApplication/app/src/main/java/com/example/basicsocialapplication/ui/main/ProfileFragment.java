package com.example.basicsocialapplication.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.basicsocialapplication.R;
import com.example.basicsocialapplication.model.User;

public class ProfileFragment extends Fragment {

    private View root;

    private TextView name_tv;
    private TextView username_tv;
    private TextView id_tv;

    private TextView city_tv;

    private TextView email_tv;
    private TextView phone_tv;

    private TextView company_tv;

    private User user;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.profile_fragment, container, false);

        name_tv = root.findViewById(R.id.profile_name);
        id_tv = root.findViewById(R.id.profile_id);
        username_tv = root.findViewById(R.id.profile_username);
        email_tv = root.findViewById(R.id.profile_email);
        phone_tv = root.findViewById(R.id.profile_mobile_tv);

        name_tv.setText(getArguments().getString("key"));

        return root;
    }
}