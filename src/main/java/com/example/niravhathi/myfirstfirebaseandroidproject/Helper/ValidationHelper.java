package com.example.niravhathi.myfirstfirebaseandroidproject.Helper;

public class ValidationHelper {

    public static boolean isValid(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            return false;
        }
        return true;
    }

}
