package com.example.basicsocialapplication.ui.authorization;

public interface IAuthorizationView {

    interface ISignIn {

        void emailError(String signInEmailError);

        void passwordError(String signInPasswordError);

    }

    interface ISignUp {

        void loginError(String signUpLoginError);

        void emailError(String signUpEmailError);

        void passwordError(String signUpPasswordError);

        void confirmPasswordError(String signUpConfirmPasswordError);

    }

    interface ForgotPassword {

        void emailError(String forgotPasswordEmailError);

    }

}
