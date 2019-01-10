package com.example.niravhathi.myfirstfirebaseandroidproject.Support;

import android.app.Activity;


import com.example.niravhathi.myfirstfirebaseandroidproject.Helper.UIHelper;
import com.example.niravhathi.myfirstfirebaseandroidproject.Helper.ValidationHelper;
import com.example.niravhathi.myfirstfirebaseandroidproject.R;
import com.example.niravhathi.myfirstfirebaseandroidproject.UserAuthentication.UserRegistration;



public class UserRegistrationSupport implements SuccessStateInterface {

    Activity activity;
    private UserRegistration userRegistration;

    public UserRegistrationSupport(Activity activity) {
        this.activity = activity;
        userRegistration = new UserRegistration(activity);
    }

    /**
     *
     * @param username
     * @param password
     */
    public void registerUser(String username, String password) {
        if (ValidationHelper.isValid(username, password)) {
            //UIHelper.showProgressDialog(context.getString(R.string.registration_in_process));
            userRegistration.registerUser(username, password, this);
        } else {
            //UIHelper.hideProgressDialog();
            UIHelper.showToast(R.string.invalid_input_toast_text);
            onInvalidInputFields(true);
        }
    }

    /**
     * Checking registration status
     * @param registrationState
     */
    @Override
    public void isSuccessful(boolean registrationState) {
        onRegistrationCallback(registrationState);
        if (registrationState) {
            UIHelper.showToast(R.string.registration_successful_text);
        } else {
            UIHelper.showToast(R.string.registration_failed_text);
        }
    }

    protected void onRegistrationCallback(boolean success) {

    }

    protected void onInvalidInputFields(boolean invalid){

    }
}
