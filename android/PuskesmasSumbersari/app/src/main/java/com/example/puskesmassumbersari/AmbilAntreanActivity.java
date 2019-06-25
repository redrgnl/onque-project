package com.example.puskesmassumbersari;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.puskesmassumbersari.controllers.SessionManager;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.HashMap;


public class AmbilAntreanActivity extends Activity implements AdapterView.OnItemSelectedListener {

    private Spinner spinnerPoli;
    private Button btnAntre, btnBatal;
    private String[] arrPoli = {"-- Pilih Poli Tujuan --", "Poli Mata", "Poli Gigi",
            "Poli Umum", "Poli Kandungan"};
    private TextView textViewNoIndex, textViewNama, textViewAlamat;
    // Session untuk mengambil data pasien
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambil_antrean);

        spinnerPoli = (Spinner) findViewById(R.id.spinner_poli);
        spinnerPoli.setOnItemSelectedListener(this);

        // Memasukkan array arrPoli ke dalam spinner
        ArrayAdapter<String> arr = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arrPoli);
        arr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPoli.setAdapter(arr);

        // Instansiasi session
        sessionManager = new SessionManager(getApplicationContext());

        textViewNoIndex = (TextView) findViewById(R.id.textViewNoIndex);
        textViewNama = (TextView) findViewById(R.id.textViewNama);
        textViewAlamat = (TextView) findViewById(R.id.textViewAlamat);

        // Mengambil data pasien dari session
        HashMap<String, String> pasien = sessionManager.getUserDetails();
        String NoIndex = pasien.get(sessionManager.KEY_INDEX_PASIEN);
        String Nama = pasien.get(sessionManager.KEY_NAMA_PASIEN);
        String Alamat = pasien.get(sessionManager.KEY_ALAMAT_PASIEN);

        textViewNoIndex.setText(Html.fromHtml(NoIndex));
        textViewNama.setText(Html.fromHtml(Nama));
        textViewAlamat.setText(Html.fromHtml(Alamat));

        // Tombol antre
        btnAntre = (Button) findViewById(R.id.btnAntre);
        btnAntre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Method menambah antrean
                addAntrrean();
            }
        });

        // Tombol batal
        btnBatal = (Button) findViewById(R.id.btnBatal);
        btnBatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AmbilAntreanActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addAntrrean() {
        /*
        spinnerPoli = (Spinner) findViewById(R.id.spinner_poli);
        btnAntre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AmbilAntreanActivity.this, "OnClickListener : " +
                        "\nPoli : " + String.valueOf(spinnerPoli.getSelectedItem()), Toast.LENGTH_SHORT).show();
            }
        });*/

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position!=0) Toast.makeText(this, "Anda memilih : " + arrPoli[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this, "Silakan pilih Poli", Toast.LENGTH_LONG).show();
    }
}
