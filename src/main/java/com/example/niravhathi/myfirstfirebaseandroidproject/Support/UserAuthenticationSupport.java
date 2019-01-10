package com.example.niravhathi.myfirstfirebaseandroidproject.Support;

import android.app.Activity;

import com.example.niravhathi.myfirstfirebaseandroidproject.Helper.UIHelper;
import com.example.niravhathi.myfirstfirebaseandroidproject.Helper.ValidationHelper;
import com.example.niravhathi.myfirstfirebaseandroidproject.R;
import com.example.niravhathi.myfirstfirebaseandroidproject.UserAuthentication.UserLogin;
import com.example.niravhathi.myfirstfirebaseandroidproject.app.UserLoginActivity;

public class UserAuthenticationSupport implements SuccessStateInterface{
    Activity activity;
    private UserLogin userLogin;

    public UserAuthenticationSupport(Activity activity) {
        this.activity = activity;
        userLogin = new UserLogin(activity);
    }
    public void loginUser(String username, String password) {
        if (ValidationHelper.isValid(username, password)) {
            //UIHelper.showProgressDialog(context.getString(R.string.registration_in_process));
            userLogin.login(username, password,this);
        } else {
            //UIHelper.hideProgressDialog();
            UIHelper.showToast(R.string.invalid_input_toast_text);
            onInvalidInputFields(true);
        }
    }

    /**
     * Checking Login State
     * @param loginState
     */
    @Override
    public void isSuccessful(boolean loginState) {
        onLoginCallback(loginState);
        if (loginState) {
            UIHelper.showToast(R.string.login_success_text);
        } else {
            UIHelper.showToast(R.string.login_failed_text);
        }
    }
    protected void onLoginCallback(boolean success){

    }

    protected void onInvalidInputFields(boolean invalid){

    }
}
