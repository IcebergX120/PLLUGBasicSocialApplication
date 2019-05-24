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

public class SingUpFragment extends Fragment implements IAuthorizationView.ISignUp{

    private View v;

    EditText login_to_signup, email_to_signup, password_to_signup, confirm_password_to_signup;
    TextView already_have_account;
    Button signUp_btn;

    SignUpPresenter signUpPresenter;

    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.signup_fragment, container, false);

        initView();
        initPresenter();
        initOnClickListener();

        return v;
    }

    public void initView() {
        login_to_signup = v.findViewById(R.id.login_to_singup);
        email_to_signup = v.findViewById(R.id.email_to_signup);
        password_to_signup = v.findViewById(R.id.password_to_signup);
        confirm_password_to_signup = v.findViewById(R.id.confirm_password_to_signup);
        already_have_account = v.findViewById(R.id.already_have_account);
        signUp_btn = v.findViewById(R.id.signUp_btn);
    }

    public void initPresenter() {
        signUpPresenter = new SignUpPresenter(this, getActivity());
    }

    public void initOnClickListener() {
        signUp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = login_to_signup.getText().toString();
                String email = email_to_signup.getText().toString();
                String password = password_to_signup.getText().toString();
                String confirm_password = confirm_password_to_signup.getText().toString();
                signUpPresenter.signUp(login, email, password, confirm_password);
            }
        });

        already_have_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpPresenter.showSignIn();
            }
        });
    }

    @Override
    public void loginError(String signUpLoginError) {
        Toast.makeText(getActivity(), signUpLoginError, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void emailError(String signUpEmailError) {
        Toast.makeText(getActivity(), signUpEmailError, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void passwordError(String signUpPasswordError) {
        Toast.makeText(getActivity(), signUpPasswordError, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void confirmPasswordError(String signUpConfirmPasswordError) {
        Toast.makeText(getActivity(), signUpConfirmPasswordError, Toast.LENGTH_SHORT).show();
    }
}
