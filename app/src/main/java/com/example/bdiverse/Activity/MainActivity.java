package com.example.bdiverse.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.bdiverse.Adapter.OpenFragmentAdapter;
import com.example.bdiverse.Fragment.Done;
import com.example.bdiverse.Fragment.Indox;
import com.example.bdiverse.Fragment.OpenFrgament;
import com.example.bdiverse.Fragment.Settings;
import com.example.bdiverse.Fragment.Updates;
import com.example.bdiverse.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OpenFrgament.OpenFragmentListener, Done.DonefragmentListener, Updates.UpdatesFragmentListener, Indox.IndexFragmentListener, Settings.SettingsFragmentListener {

    private BottomNavigationView mBottomNavigationView;
    private ArrayList <View> initLinColor = new ArrayList<>();
    private OpenFrgament mOpenFrgament;
    private Done mDone;
    private Updates mUpdates;
    private Indox mIndox;
    private  Settings mSettings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initStatusBarColor();
        initBottomNavigationItemView();




    }

    private void initStatusBarColor() {
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(),R.color.backroundAm));
    }

    private void initBottomNavigationItemView() {
        initshooSelect();
        mBottomNavigationView = findViewById(R.id.AM_BottomNavigationView);
        mOpenFrgament = OpenFrgament.newInstance();
        initFragment(mOpenFrgament,"OpenFrgament");

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.action_Open:
                        managherSelect(0);
                        initFragment(mOpenFrgament,"OpenFrgament");
                        return true;
                    case R.id.action_Done:
                        managherSelect(1);
                        if (mDone==null){
                            mDone = Done.newInstance();
                        }
                        initFragment(mDone,"Done");
                        return true;
                    case R.id.action_Updates:
                        managherSelect(2);
                        if (mUpdates == null) {
                             mUpdates = Updates.newInstance();
                        }
                        initFragment(mUpdates,"Updates");
                        return true;
                    case R.id.action_Inbox:
                        managherSelect(3);
                        if (mIndox ==null){
                            mIndox = Indox.newInstance();
                        }
                        initFragment(mIndox,"Inbox");
                        return true;
                    case R.id.action_Settings:
                        managherSelect(4);
                        if (mSettings == null) {
                             mSettings = Settings.newInstance();
                        }
                        initFragment(mSettings,"Settings");
                        return true;
                }
                return false;
            }
        });
        }


    private void initshooSelect() {
       initLinColor.add(findViewById(R.id.BN_selector_blu1));
        initLinColor.add(findViewById(R.id.BN_selector_blu2));
        initLinColor.add(findViewById(R.id.BN_selector_blu3));
        initLinColor.add(findViewById(R.id.BN_selector_blu4));
        initLinColor.add(findViewById(R.id.BN_selector_blu5));
    }

    private void managherSelect(int pozisen) {
        for (int i = 0; i <initLinColor.size(); i++) {
            if (i!=pozisen) {
                initLinColor.get(i).setVisibility(View.INVISIBLE);
            } else {
                initLinColor.get(i).setVisibility(View.VISIBLE);
            }
        }

    }


    private void initFragment(Fragment fragment,String name){
         getSupportFragmentManager()
                 .beginTransaction()
                 .addToBackStack(name)
                 .replace(R.id.AM_fl_FL,fragment).commit();
     }





    @Override
    public void DonefragmentInteraction() {

    }

    @Override
    public void IndexInteraction() {

    }

    @Override
    public void OpenFragmentInteraction() {

    }

    @Override
    public void SettingsInteraction() {

    }

    @Override
    public void UpdatesInteraction() {

    }

    @Override
    public void onBackPressed() {
        List <Fragment> fList = getSupportFragmentManager().getFragments();
        if (fList.get(fList.size()-1)instanceof OpenFrgament){
//            super.onBackPressed();
            finish();
        }else {
            mBottomNavigationView.setSelectedItemId(R.id.action_Open);
//            funcsenSwich(R.id.action_Open);

        }

    }

}

