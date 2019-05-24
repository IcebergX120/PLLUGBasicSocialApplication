package com.example.basicsocialapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.basicsocialapplication.ui.authorization.AboutFragment;
import com.example.basicsocialapplication.ui.authorization.ForgotPasswordFragment;
import com.example.basicsocialapplication.ui.authorization.SignInFragment;
import com.example.basicsocialapplication.ui.authorization.SingUpFragment;

public class MainAuthorizationActivity extends AppCompatActivity implements IMainAuthorizationView {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authorization_activity_main);

        replaceFragment(new SignInFragment());
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_authorization_container, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void showSignIn() {
        replaceFragment(new SignInFragment());
    }

    @Override
    public void showSignUp() {
        replaceFragment(new SingUpFragment());
    }

    @Override
    public void showForgotPassword() {
        replaceFragment(new ForgotPasswordFragment());
    }

    @Override
    public void showAbout() {
        replaceFragment(new AboutFragment());
    }

    @Override
    public void showMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
