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

import com.android.volley.AuthFailureError;
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
import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

public class AmbilAntreanActivity extends Activity implements AdapterView.OnItemSelectedListener {

    private Spinner spinnerPoli;
    private Button btnAntre, btnBatal;
    private TextView textViewNoAntrean, textViewNoIndex, textViewNama, textViewAlamat;
    int intLastNomor, intNomorUrut;
    private String nomorUrut;
    private String NoIndex, Nama, Alamat, Poli;

    // Inisialisasi variabel arrPoli
    private String[] arrPoli = {"-- Pilih Poli Tujuan --", "Poli Mata", "Poli Gigi",
            "Poli Umum", "Poli Kandungan"};

    //URL REST API Antrian
    public static final String URL = Server.URL + "api/app_antrian/index_get"; // Ambil data antrean
    public static final String URL_Antre = ""; // Kirim data pasien

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
        NoIndex = pasien.get(sessionManager.KEY_INDEX_PASIEN);
        Nama = pasien.get(sessionManager.KEY_NAMA_PASIEN);
        Alamat = pasien.get(sessionManager.KEY_ALAMAT_PASIEN);

        // Mengambil data antrean terakhir ditambah 1 sebagai nomor antrean pasien selanjutnya
        loadNomorUrut();

        // Set text
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position!=0) {
            Toast.makeText(this, "Anda memilih : " + arrPoli[position], Toast.LENGTH_LONG).show();
            Poli = arrPoli[position];
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this, "Silakan pilih Poli", Toast.LENGTH_LONG).show();
    }

    private void loadNomorUrut() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    // Ambil data JSON
                    JSONObject object = new JSONObject(response);
                    JSONArray antreanArray = object.getJSONArray("result");
                    JSONObject antreanObject = antreanArray.getJSONObject(0);
                    String lastNomor = antreanObject.getString("last_nomor");

                    if (lastNomor == "-") {
                        lastNomor = "1";
                        intLastNomor = Integer.valueOf(lastNomor);
                        nomorUrut = String.valueOf(intLastNomor);
                    } else {
                        intLastNomor = Integer.valueOf(lastNomor);
                        intNomorUrut = ++intLastNomor;
                        nomorUrut = String.valueOf(intNomorUrut);
                    }
                    textViewNoAntrean = (TextView) findViewById(R.id.textViewNoAntrean);
                    textViewNoAntrean.setText(nomorUrut);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
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
        StringRequest stringRequest = new StringRequest(StringRequest.Method.GET, URL_Antre, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");

                    if (success.equals("1")) {
                        Toast.makeText(AmbilAntreanActivity.this, "Berhasil mendaftar antrean!",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(AmbilAntreanActivity.this, AntreanAndaActivity.class);
                        startActivity(intent);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(AmbilAntreanActivity.this, "Gagal mendaftar antrean : " + e.toString(),
                            Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError e) {
                Toast.makeText(AmbilAntreanActivity.this, "Gagal mendaftar antrean : " + e.toString(),
                        Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams () throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("", nomorUrut);
                params.put("pas_index", NoIndex);
                params.put("pas_nama", Nama);
                params.put("pas_alamat", Alamat);
                params.put("pas_poli", Poli);
                return params;
            }
        };
    }
}
