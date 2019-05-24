package com.example.basicsocialapplication.ui.authorization;

import android.app.Activity;
import android.text.TextUtils;

import com.example.basicsocialapplication.IMainAuthorizationView;

public class SignUpPresenter {

    private IAuthorizationView.ISignUp view;
    private IMainAuthorizationView authorizationView;

    public SignUpPresenter(IAuthorizationView.ISignUp view, Activity activity) {
        this.view = view;
        authorizationView = (IMainAuthorizationView) activity;
    }

    public void signUp(String login, String email, String password, String confirm_password) {
        if((validateInputLogin(login) && validateInputEmail(email)) &&
                (validateInputPassword(password) && validateConfirmPassword(password, confirm_password))){
            authorizationView.showSignUp();
        }
    }

    private boolean validateInputLogin(String login) {
        if (TextUtils.isEmpty(login)) {
            view.loginError("Login is empty");
            return false;
        } else { return true; }
    }

    private boolean validateInputEmail(final String email){
        if(TextUtils.isEmpty(email)){
            view.emailError("Email is empty");
            return false;
        }
        else { return true; }
    }

    private boolean validateInputPassword(final String password){
        if(TextUtils.isEmpty(password)){
            view.passwordError("Password is empty");
            return false;
        }
        else { return true; }
    }

    private boolean validateConfirmPassword(final String password, final String confirmPassword){
        if(!(TextUtils.equals(password, confirmPassword))){
            view.confirmPasswordError("Passwords do not match");
            return false;
        }
        else { return true; }
    }

    public void showSignIn() {
        authorizationView.showSignIn();
    }
}
