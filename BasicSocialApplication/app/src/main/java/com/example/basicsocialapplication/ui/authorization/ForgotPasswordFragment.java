package com.example.basicsocialapplication.ui.authorization;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.basicsocialapplication.R;

public class ForgotPasswordFragment extends Fragment implements IAuthorizationView.ForgotPassword{

    View v;

    EditText enterEmailToForgotPassword;
    TextView backToSignIn;
    Button sendRecoverBtn;

    ForgotPasswordPresenter forgotPasswordPresenter;

    FragmentManager fragmentManager;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.forgot_password_fragment, container, false);

        fragmentManager = getActivity().getSupportFragmentManager();

        initView();
        initPresenter();
        initOnClickListener();

        return v;
    }

    public void initView() {
        enterEmailToForgotPassword = v.findViewById(R.id.enter_email_to_forgot_password);
        backToSignIn = v.findViewById(R.id.back_to_sign);
        sendRecoverBtn = v.findViewById(R.id.send_recover_code_btn);
    }

    public void initPresenter() {
        forgotPasswordPresenter = new ForgotPasswordPresenter(this, getActivity());
    }

    public void initOnClickListener() {
        sendRecoverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = enterEmailToForgotPassword.getText().toString();
                forgotPasswordPresenter.sendRecoveryCode(email);
            }
        });

        backToSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forgotPasswordPresenter.showSignIn();
            }
        });
    }

    @Override
    public void emailError(String forgotPasswordEmailError) {
        Toast.makeText(getActivity(), forgotPasswordEmailError, Toast.LENGTH_SHORT).show();
    }
}
