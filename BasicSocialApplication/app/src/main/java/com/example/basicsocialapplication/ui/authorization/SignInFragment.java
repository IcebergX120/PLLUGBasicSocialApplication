package com.example.basicsocialapplication.ui.authorization;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.basicsocialapplication.R;

public class SignInFragment extends Fragment implements IAuthorizationView.ISignIn {

    private View v;

    private EditText enter_email, enter_password;
    private TextView forgot_password, signUp, about;
    private Button signIn_btn;

    private SignInPresenter signInPresenter;

    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.signin_fragment, container, false);

        initView();
        initPresenter();
        initOnClickListener();

        return v;
    }

    public void initView() {
        enter_email = v.findViewById(R.id.enter_email);
        enter_password = v.findViewById(R.id.enter_password);
        forgot_password = v.findViewById(R.id.forgot_password);
        signUp = v.findViewById(R.id.signUp);
        signIn_btn = v.findViewById(R.id.signIn_btn);
        about = v.findViewById(R.id.about);
    }

    public void initPresenter() {
        signInPresenter = new SignInPresenter(this, getActivity());
    }

    public void initOnClickListener() {
        signIn_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = enter_email.getText().toString();
                String password = enter_password.getText().toString();
                signInPresenter.signIn(email, password);
            }
        });

        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInPresenter.forgot_password();
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInPresenter.signUp();
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInPresenter.about();
            }
        });
    }

    @Override
    public void emailError(String signInEmailError) {
        Toast.makeText(getActivity(), signInEmailError, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void passwordError(String signInPasswordError) {
        Toast.makeText(getActivity(), signInPasswordError, Toast.LENGTH_SHORT).show();
    }
}
