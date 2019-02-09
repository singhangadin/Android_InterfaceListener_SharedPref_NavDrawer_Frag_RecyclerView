package com.example.user.android_interfacelistener_sharedpref_navdrawer_frag_recyclerview.views;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.user.android_interfacelistener_sharedpref_navdrawer_frag_recyclerview.views.fragments.GetDataFragment;
import com.example.user.android_interfacelistener_sharedpref_navdrawer_frag_recyclerview.views.fragments.HomeFragment;
import com.example.user.android_interfacelistener_sharedpref_navdrawer_frag_recyclerview.R;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        // drawerToggle = setupDrawerToogle();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);

        // drawerLayout.addDrawerListener(drawerToggle);

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        setupDrawerContent(navigationView);


        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.home_fragment);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch ((item.getItemId())){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerContent(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                selectDrawerItem(menuItem);
                return true;
            }
        });
    }

    public void selectDrawerItem(MenuItem menuItem){
        switch (menuItem.getItemId()){

            case R.id.home_fragment :
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,new HomeFragment()).commit();
                break;

            case R.id.send_data :
                Intent intent = new Intent(this, SendDataActivity.class);
                startActivity(intent);
                break;

                case R.id.get_data :
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,new GetDataFragment()).commit();
                break;
        }

        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }


}
