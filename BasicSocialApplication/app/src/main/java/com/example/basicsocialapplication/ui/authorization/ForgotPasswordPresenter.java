package com.example.basicsocialapplication.ui.authorization;

import android.app.Activity;
import android.text.TextUtils;

import com.example.basicsocialapplication.IMainAuthorizationView;
import com.example.basicsocialapplication.MainAuthorizationActivity;

public class ForgotPasswordPresenter extends MainAuthorizationActivity {

    private IAuthorizationView.ForgotPassword view;
    private IMainAuthorizationView authorizationView;

    public ForgotPasswordPresenter(IAuthorizationView.ForgotPassword view, Activity activity){
        this.view = view;
        authorizationView = (IMainAuthorizationView) activity;
    }

    public void sendRecoveryCode(String email) {
        if(validateEmail(email)){
        }
        else{
            view.emailError("Email is empty");
        }
    }

    private boolean validateEmail(String email){
        if(TextUtils.isEmpty(email)) {
            return false;
        }
        else{ return true; }
    }

    public void showSignIn (){
        authorizationView.showSignIn();
    }

}
