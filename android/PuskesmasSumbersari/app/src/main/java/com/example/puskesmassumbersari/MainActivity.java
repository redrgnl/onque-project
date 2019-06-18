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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.puskesmassumbersari.config.Server;
import com.example.puskesmassumbersari.controllers.SessionManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    // manajemen session untuk log in, log out dan manajemen data pasien
    SessionManager SessionManager;

    // deklarasi variabel
    ListView listView;
    private List<AntreanItem> antreanItemList;
    Button btnAmbilAntrian;
    Button btnUpdateAntrian;

    //URL REST API Antrian
    public static final String URL = Server.URL + "api/app_antrian/index_get";

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
        SessionManager sessionManager = new SessionManager(getApplicationContext());
        SessionManager.isLoggedIn();
        SessionManager.checkLogin();

        // inisiasi nomor antrean
        listView = findViewById(R.id.ViewNomor);
        antreanItemList = new ArrayList<>();

        // tampilkan nomor antrean
        loadNomor();

        // memperbarui nomor antrian dari website
        btnUpdateAntrian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // refresh activity
        /*refresh = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(refresh, 1000);
            }
        };
        handler.post(refresh);*/

    }

    private void loadNomor() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    // Ambil data JSON
                    JSONObject object = new JSONObject(response);
                    JSONArray antreanArray = object.getJSONArray("result");
                    for (int i = 0; i < antreanArray.length(); i++) {
                        JSONObject antreanObject = antreanArray.getJSONObject(i);
                        AntreanItem antreanItem = new AntreanItem(
                                antreanObject.getString("running_nomor"),
                                antreanObject.getString("last_nomor")
                        );

                        antreanItemList.add(antreanItem);
                    }

                    ListAdapter adapter = new com.example.puskesmassumbersari.ListAdapter(antreanItemList, getApplicationContext());
                    listView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
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
