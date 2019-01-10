package com.example.niravhathi.myfirstfirebaseandroidproject.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.niravhathi.myfirstfirebaseandroidproject.Helper.IntentHelper;
import com.example.niravhathi.myfirstfirebaseandroidproject.R;
import com.example.niravhathi.myfirstfirebaseandroidproject.Support.UserRegistrationSupport;

public class UserRegistrationActivity extends AppCompatActivity {
    EditText username_EditText, password_EditText;
    Button registration_Button;
    String username = null, password = null;
    UserRegistrationSupport userRegistrationSupport;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);
        username_EditText = findViewById(R.id.username_EditText);
        password_EditText = findViewById(R.id.password_EditText);
        registration_Button = findViewById(R.id.registration_Button);
        registration_Button.setOnClickListener(new getUsernameAndPasswordForRegistration());

        userRegistrationSupport = new UserRegistrationSupport(this) {
            @Override
            protected void onRegistrationCallback(boolean success) {
                if (success) {
                    emptyFields();
                    redirectToLoginActivity();
                }
            }

            @Override
            protected void onInvalidInputFields(boolean invalid) {
                if (invalid)
                    showInputFieldError();
            }
        };

    }


    /**
     * Username & Password Input class
     */
    private class getUsernameAndPasswordForRegistration implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            username = username_EditText.getText().toString().trim();
            password = password_EditText.getText().toString().trim();
            userRegistrationSupport.registerUser(username, password);
        }
    }

    public void emptyFields() {
        username_EditText.setText("");
        password_EditText.setText("");
    }

    public void redirectToLoginActivity() {
        IntentHelper.startNewActivity(this, UserLoginActivity.class);
    }

    public void showInputFieldError() {
        username_EditText.setError(getString(R.string.error_username));
        password_EditText.setError(getString(R.string.error_password));
    }
}




