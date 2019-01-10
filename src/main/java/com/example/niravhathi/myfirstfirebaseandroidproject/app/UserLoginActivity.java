package com.example.niravhathi.myfirstfirebaseandroidproject.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.niravhathi.myfirstfirebaseandroidproject.Helper.IntentHelper;
import com.example.niravhathi.myfirstfirebaseandroidproject.R;
import com.example.niravhathi.myfirstfirebaseandroidproject.Support.UserAuthenticationSupport;

public class UserLoginActivity extends AppCompatActivity {

    private EditText username_EditText, password_EditText;
    Button login_Button;
    UserAuthenticationSupport userAuthenticationSupport;
    String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        username_EditText = findViewById(R.id.username_EditText);
        password_EditText = findViewById(R.id.password_EditText);
        login_Button = findViewById(R.id.login_Button);
        login_Button.setOnClickListener(new getUsernamePasswordForLogin());

        userAuthenticationSupport = new UserAuthenticationSupport(this){
            @Override
            protected void onLoginCallback(boolean success) {
                if(success){
                    emptyFields();
                    redirectToHomeActivity();
                }

            }

            @Override
            protected void onInvalidInputFields(boolean invalid) {
                super.onInvalidInputFields(invalid);
            }
        };
    }

    /**
     * Username & Password Input class
     */
    private class getUsernamePasswordForLogin implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            username = username_EditText.getText().toString().trim();
            password = password_EditText.getText().toString().trim();
            userAuthenticationSupport.loginUser(username, password);
        }
    }

    public void emptyFields() {
        username_EditText.setText("");
        password_EditText.setText("");
    }

    public void redirectToHomeActivity() {
        IntentHelper.startNewActivity(this, HomeActivity.class);
    }


}



