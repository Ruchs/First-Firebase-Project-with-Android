package com.example.niravhathi.myfirstfirebaseandroidproject.UserAuthentication;

import android.app.Activity;
import android.support.annotation.NonNull;
import com.example.niravhathi.myfirstfirebaseandroidproject.Support.SuccessStateInterface;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class UserRegistration {

    private Activity activity;
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    public UserRegistration(Activity activity) {
        this.activity = activity;
    }

    public void registerUser(String username, String password, final SuccessStateInterface callback) {
        Task<AuthResult> authResultTask = firebaseAuth.createUserWithEmailAndPassword(username, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            callback.isSuccessful(true);
                        } else {
                            callback.isSuccessful(false);
                        }
                    }
                });
    }


}

