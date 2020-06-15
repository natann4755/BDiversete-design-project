package com.example.bdiverse;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.bdiverse.Activity.LoginActivity;
import com.example.bdiverse.Activity.MainActivity;

import static com.example.bdiverse.Activity.LoginActivity.keyPASSWORD;
import static com.example.bdiverse.Activity.LoginActivity.keyUSERNAME;

public class MyApplication extends Application {




    @Override
    public void onCreate() {
        super.onCreate();
        moovToLoginActivity();
    }




    private void moovToLoginActivity() {
        SharedPreferences myUser = this.getSharedPreferences(
                " myUser", Context.MODE_PRIVATE);
        String name = myUser.getString(keyUSERNAME, null);
        String pass = myUser.getString(keyPASSWORD, null);

        if (name!=null && pass!=null){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        }else   {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        }


    }

}
