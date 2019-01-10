package com.example.niravhathi.myfirstfirebaseandroidproject.UserAuthentication;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.example.niravhathi.myfirstfirebaseandroidproject.Support.SuccessStateInterface;
import com.example.niravhathi.myfirstfirebaseandroidproject.app.App;
import com.example.niravhathi.myfirstfirebaseandroidproject.app.UserLoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.concurrent.Executor;

public class UserLogin {

    private Activity activity;
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    public UserLogin(Activity activity) {
        this.activity = activity;
    }

    public void login(String username, String password, final SuccessStateInterface callback) {
        Task<AuthResult> authResultTask = firebaseAuth.signInWithEmailAndPassword(username, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            callback.isSuccessful(true);
                        } else {
                            callback.isSuccessful(false);
                        }
                    }
                });
    }
}
