package com.example.puskesmassumbersari;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.puskesmassumbersari.config.Server;
import com.example.puskesmassumbersari.controllers.SessionManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity<refresh> extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    SessionManager SessionManager;

    TextView noAntrianSekarang, antrianTerakhir;
    Button btnAmbilAntrian;

    //URL REST API Antrian
    public static String URL = Server.URL + "api/app_antrian/index_get";

    Handler handler = new Handler();

    Runnable refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout_main);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        // inisiasi variabel nomor antrean dan tombol ambil antrean
        noAntrianSekarang = (TextView) findViewById(R.id.noAntrianSekarang);
        antrianTerakhir = (TextView) findViewById(R.id.antrianTerakhir);
        btnAmbilAntrian = (Button) findViewById(R.id.btnTambahAntrian);



        /*refresh = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(refresh, 1000);
            }
        };
        handler.post(refresh);*/

        // nomor antrean

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout_main);
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

        DrawerLayout drawer = findViewById(R.id.drawer_layout_main);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    // method nomor antrian
    public void queue_num(final String noAntrianSekarang, final String antrianTerakhir){


    }


}
