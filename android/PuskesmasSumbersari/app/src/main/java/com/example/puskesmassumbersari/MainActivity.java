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
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
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

    TextView noAntrianSekarang, noAntrianTerakhir;
    Button btnAmbilAntrian;
    Button btnUpdateAntrian;

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
        noAntrianTerakhir = (TextView) findViewById(R.id.noAntrianTerakhir);
        btnAmbilAntrian = (Button) findViewById(R.id.btnAmbilAntrian);
        btnUpdateAntrian = (Button) findViewById(R.id.btnUpdateAntrian);

        // memperbarui nomor antrian dari website
        btnUpdateAntrian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String AntreanSekarang = jsonObject.getString("running_nomor");
                            String AntreanTerakhir = jsonObject.getString("last_nomor");

                            // set nomor antrean sekarang dan nomor antrean terakhir
                            noAntrianSekarang.setText(AntreanSekarang);
                            noAntrianTerakhir.setText(AntreanTerakhir);

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(MainActivity.this, "Error message : " + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Error message : " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }){
                    //?
                };
            }
        });

        /*refresh = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(refresh, 1000);
            }
        };
        handler.post(refresh);*/

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

}
