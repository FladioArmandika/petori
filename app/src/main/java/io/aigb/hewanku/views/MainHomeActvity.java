package io.aigb.hewanku.views;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import io.aigb.hewanku.R;
import io.aigb.hewanku.views.fragments.HomeFragment;
import io.aigb.hewanku.views.fragments.InboxFragment;
import io.aigb.hewanku.views.fragments.InboxMessageFragment;
import io.aigb.hewanku.views.fragments.PesananFragment;
import io.aigb.hewanku.views.fragments.PesananItemFragment;
import io.aigb.hewanku.views.fragments.ProfilFragment;

public class MainHomeActvity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener,
        InboxFragment.OnFragmentInteractionListener,
        PesananFragment.OnFragmentInteractionListener,
        ProfilFragment.OnFragmentInteractionListener,
        PesananItemFragment.OnFragmentInteractionListener,
        InboxMessageFragment.OnFragmentInteractionListener {

    private TextView mTextMessage;

    BottomNavigationView bottomNav;
    BottomNavigationItemView navHome, navPesanan, navInbox, navProfil;


    ScrollView scrollViewHome;
    RelativeLayout headerBarHome;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new HomeFragment();
                    break;
                case R.id.navigation_pesanan:
                    fragment = new PesananFragment();
                    break;
                case R.id.navigation_inbox:
                    fragment = new InboxFragment();
                    break;
                case R.id.navigation_profil:
                    fragment = new ProfilFragment();
                    break;
            }
            return loadFragment(fragment);
        }
    };



    private boolean loadFragment(Fragment fragment) {
        if(fragment != null) {
            getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.homefragment_container,fragment)
                        .commit();
            return true;
        }
        return false;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home_actvity);


        bottomNav = (BottomNavigationView) findViewById(R.id.navigation);

        navHome = (BottomNavigationItemView) findViewById(R.id.navigation_home);
        navPesanan = (BottomNavigationItemView) findViewById(R.id.navigation_pesanan);
        navInbox = (BottomNavigationItemView) findViewById(R.id.navigation_inbox);
        navProfil = (BottomNavigationItemView) findViewById(R.id.navigation_profil);
        bottomNav.setItemIconTintList(null);


        scrollViewHome = (ScrollView) findViewById(R.id.scrollview_home);
        headerBarHome = (RelativeLayout) findViewById(R.id.headbar_home);



        loadFragment(new HomeFragment());

        /////////////////////
        //HOME
        ////////////////////



        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }



    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
