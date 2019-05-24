package com.example.basicsocialapplication.ui.authorization;

import android.app.Activity;
import android.text.TextUtils;

import com.example.basicsocialapplication.IMainAuthorizationView;

public class SignInPresenter {

    private IAuthorizationView.ISignIn view;
    private IMainAuthorizationView authorizationView;

    public SignInPresenter(IAuthorizationView.ISignIn view, Activity activity) {
        this.view = view;
        authorizationView = (IMainAuthorizationView) activity;
    }

    public void signIn(String email, String password) {
        if(validateInputEmail(email) && validateInputPassword(password))
            authorizationView.showMainActivity();
    }

    private boolean validateInputEmail(String email) {
        if (TextUtils.isEmpty(email)) {
            view.emailError("Email is empty");
            return false;
        }
        else { return true; }
    }

    private boolean validateInputPassword (String password) {
        if (TextUtils.isEmpty(password)) {
            view.passwordError("Password is empty");
            return false;
        } else { return true; }
    }

    public void forgot_password() {
        authorizationView.showForgotPassword();
    }

    public void signUp() {
        authorizationView.showSignUp();
    }

    public void about() {
        authorizationView.showAbout();
    }
}
