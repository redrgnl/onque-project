package com.example.puskesmassumbersari;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.puskesmassumbersari.controllers.SessionManager;

public class AntrianAndaActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    SessionManager SessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_antrian_anda);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout_antrian_anda);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout_antrian_anda);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.logout:
                SessionManager.logoutUser();
                break;
            case R.id.antrian_anda:
                startActivity(new Intent(this, AntrianAndaActivity.class));
                break;
            case R.id.profil:
                startActivity(new Intent(this, ProfilActivity.class));
                break;
            case R.id.antrian:
                startActivity(new Intent(this, MainActivity.class));
                break;

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout_antrian_anda);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
