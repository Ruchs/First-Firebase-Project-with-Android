package com.example.niravhathi.myfirstfirebaseandroidproject.Helper;

import android.app.Application;
import android.widget.Toast;

import com.example.niravhathi.myfirstfirebaseandroidproject.app.App;

import static android.widget.Toast.LENGTH_SHORT;

public class UIHelper {
    /**
     * ProgressDialog Declaration
     */
    // private static ProgressDialog progressDialog=new ProgressDialog(context);


    /**
     * @param toastMessage
     */
    public static void showToast(int toastMessage) {
        Toast.makeText(App.getInstance(), toastMessage, LENGTH_SHORT).show();
    }

    /**
     *
     * @param toastMessage
     */
    public static void showToast(String toastMessage) {
        Toast.makeText(App.getInstance(),toastMessage,LENGTH_SHORT).show();
    }

    /**
     *
     * @param progressDialogMessage
     */
    /*public static void showProgressDialog(String progressDialogMessage){
        progressDialog.setMax(500);
        progressDialog.setMessage(progressDialogMessage);
    }

    /**
     * HideProgressDialog
     */
   /* public static void hideProgressDialog(){
        progressDialog.dismiss();
        progressDialog.cancel();
    } */
}
