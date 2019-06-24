package com.example.puskesmassumbersari;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.puskesmassumbersari.controllers.SessionManager;


import java.util.HashMap;


public class ProfilActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView textViewNoIndex, textViewNama, textViewNIK, textViewKepalaKeluarga, textViewAlamat, textViewTelepon, textViewTanggalLahir, textViewAgama, textViewPendidikan, textViewJenisKelamin, textViewGolonganDarah, textViewPekerjaan;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout_profil);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        //Session
        sessionManager = new SessionManager(getApplicationContext());

        textViewNoIndex = (TextView) findViewById(R.id.textViewNoIndex);
        textViewNama = (TextView) findViewById(R.id.textViewNama);
        textViewNIK = (TextView) findViewById(R.id.textViewNIK);
        textViewKepalaKeluarga = (TextView) findViewById(R.id.textViewKepalaKeluarga);
        textViewAlamat = (TextView) findViewById(R.id.textViewAlamat);
        textViewTelepon = (TextView) findViewById(R.id.textViewTelepon);
        textViewTanggalLahir = (TextView) findViewById(R.id.textViewTanggalLahir);
        textViewAgama = (TextView) findViewById(R.id.textViewAgama);
        textViewPendidikan = (TextView) findViewById(R.id.textViewPendidikan);
        textViewJenisKelamin = (TextView) findViewById(R.id.textViewJenisKelamin);
        textViewGolonganDarah = (TextView) findViewById(R.id.textViewGolonganDarah);
        textViewPekerjaan = (TextView) findViewById(R.id.textViewPekerjaan);

        //menampilkan user data dari session
        HashMap<String, String> user = sessionManager.getUserDetails();
        String NoIndex = user.get(sessionManager.KEY_INDEX_PASIEN);
        String Nama = user.get(sessionManager.KEY_NAMA_PASIEN);
        String NIK = user.get(sessionManager.KEY_NIK_PASIEN);
        String KK = user.get(sessionManager.KEY_KK_PASIEN);
        String Alamat = user.get(sessionManager.KEY_ALAMAT_PASIEN);
        String Telepon = user.get(sessionManager.KEY_TELEPON_PASIEN);
        String Lahir = user.get(sessionManager.KEY_LAHIR_PASIEN);
        String Agama = user.get(sessionManager.KEY_AGAMA_PASIEN);
        String Pendidikan = user.get(sessionManager.KEY_PENDIDIKAN_PASIEN);
        String Kelamin = user.get(sessionManager.KEY_KELAMIN_PASIEN);
        String Darah = user.get(sessionManager.KEY_DARAH_PASIEN);
        String Pekerjaan = user.get(sessionManager.KEY_PEKERJAAN_PASIEN);

        textViewNoIndex.setText(Html.fromHtml(NoIndex));
        textViewNama.setText(Html.fromHtml(Nama));
        textViewNIK.setText(Html.fromHtml(NIK));
        textViewKepalaKeluarga.setText(Html.fromHtml(KK));
        textViewAlamat.setText(Html.fromHtml(Alamat));
        textViewTelepon.setText(Html.fromHtml(Telepon));
        textViewTanggalLahir.setText(Html.fromHtml(Lahir));
        textViewAgama.setText(Html.fromHtml(Agama));
        textViewPendidikan.setText(Html.fromHtml(Pendidikan));
        textViewJenisKelamin.setText(Html.fromHtml(Kelamin));
        textViewGolonganDarah.setText(Html.fromHtml(Darah));
        textViewPekerjaan.setText(Html.fromHtml(Pekerjaan));

    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout_profil);
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
                sessionManager.logoutUser();
                break;
            case R.id.antrian_anda:
                startActivity(new Intent(this, AntreanAndaActivity.class));
                break;
            case R.id.profil:
                startActivity(new Intent(this, ProfilActivity.class));
                break;
            case R.id.antrian:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout_profil);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}

