package com.example.niravhathi.myfirstfirebaseandroidproject.Helper;

import android.app.Activity;
import android.content.Intent;

public class IntentHelper {

    public static void startNewActivity(Activity currentActivity, Class newActivity) {
        Intent intent = new Intent(currentActivity, newActivity);
        currentActivity.startActivity(intent);
    }
}
