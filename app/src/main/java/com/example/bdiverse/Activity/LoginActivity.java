package com.example.bdiverse.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.TextView;

import com.example.bdiverse.Fragment.LoginFragment;
import com.example.bdiverse.R;

public class LoginActivity extends AppCompatActivity implements LoginFragment.OnLoginFragmentListener {


    public final static String keyUSERNAME = "USERNAME";
    public final static String keyPASSWORD = "PASSWORD";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
    }

    private void initViews() {
        getSupportFragmentManager().beginTransaction().add(R.id.login_FrameLayout,LoginFragment.newInstance()).commit();

    }



    @Override
    public boolean login(Boolean isCheced, String userName, String password) {

        if (isCheced){
            SharedPreferences myUser = this.getSharedPreferences(
                    " myUser", Context.MODE_PRIVATE);
            if (userName!=null && password!=null) {
                SharedPreferences.Editor editor = myUser.edit();
                editor.putString(keyUSERNAME, userName);
                editor.putString(keyPASSWORD, password);
                editor.apply();
            }



        }

        Log.e("fffffffffffffffff","fffffffffffffffffffffffffffff");
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        return false;
    }
}
