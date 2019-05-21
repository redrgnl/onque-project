package com.example.puskesmassumbersari;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.puskesmassumbersari.controllers.SessionManager;


import java.util.HashMap;


public class ProfilActivity extends AppCompatActivity {

    private TextView textViewNoIndex, textViewNama, textViewNIK, textViewKepalaKeluarga, textViewAlamat, textViewTelepon, textViewTanggalLahir, textViewAgama, textViewPendidikan, textViewJenisKelamin, textViewGolonganDarah, textViewPekerjaan;
    SessionManager SessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        //Session
        SessionManager = new SessionManager(getApplicationContext());

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
        textViewGolonganDarah = (TextView) findViewById(R.id.textViewGolonganDrah);
        textViewPekerjaan = (TextView) findViewById(R.id.textViewPekerjaan);

        //menampilkan user data
        HashMap<String, String> user = SessionManager.getUserDetails();
        String NoIndex = user.get(SessionManager.KEY_INDEX_PASIEN);
        String Nama = user.get(SessionManager.KEY_NAMA_PASIEN);
        String NIK = user.get(SessionManager.KEY_NIK_PASIEN);
        String KK = user.get(SessionManager.KEY_KK_PASIEN);
        String Alamat = user.get(SessionManager.KEY_ALAMAT_PASIEN);
        String Telepon = user.get(SessionManager.KEY_TELEPON_PASIEN);
        String Lahir = user.get(SessionManager.KEY_LAHIR_PASIEN);
        String Agama = user.get(SessionManager.KEY_AGAMA_PASIEN);
        String Pendidikan = user.get(SessionManager.KEY_PENDIDIKAN_PASIEN);
        String Kelamin = user.get(SessionManager.KEY_KELAMIN_PASIEN);
        String Darah = user.get(SessionManager.KEY_DARAH_PASIEN);
        String Pekerjaan = user.get(SessionManager.KEY_PEKERJAAN_PASIEN);

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

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

