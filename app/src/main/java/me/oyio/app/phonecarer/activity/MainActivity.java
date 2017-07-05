package me.oyio.app.phonecarer.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManagerNonConfig;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import me.oyio.app.phonecarer.R;
import me.oyio.app.phonecarer.fragment.DashBoardFragment;
import me.oyio.app.phonecarer.fragment.HomeFragment;
import me.oyio.app.phonecarer.fragment.SettingsFragment;

public class MainActivity extends AppCompatActivity
        implements DashBoardFragment.OnFragmentInteractionListener,
        HomeFragment.OnFragmentInteractionListener,
        SettingsFragment.OnFragmentInteractionListener {

    private FragmentManager fm = getSupportFragmentManager();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction transaction = fm.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Fragment fragment = new HomeFragment();
                    transaction.replace(R.id.main_container, fragment).commit();
                    return true;
                case R.id.navigation_dashboard:
                    Fragment dashBoardFragment = new DashBoardFragment();
                    transaction.replace(R.id.main_container, dashBoardFragment).commit();
                    return true;
                case R.id.navigation_settings:
                    Fragment settingFragment = new SettingsFragment();
                    transaction.replace(R.id.main_container, settingFragment).commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fm.beginTransaction().replace(R.id.main_container, new HomeFragment()).commit();
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
