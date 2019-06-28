package com.example.puskesmassumbersari.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.puskesmassumbersari.MainActivity;
import com.example.puskesmassumbersari.R;
import com.example.puskesmassumbersari.config.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    // deklarasi objek
    TextInputLayout validasiIndexPasien, validasiNIK;
    EditText txtIndexPasien, txtNIK;
    Button btnLogin;
    TextView txtRegistrasi;

    // deklarasi variabel
    String IndexPasien, NIK;

    // deklarasi variabel alamat host
    // setting terlebih dahulu supaya antara laptop dan android jadi satu jaringan
    public static String URL = Server.URL + "api/app_login/index_login";

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sessionManager = new SessionManager(this);

        // inisialisasi variabel objek
        validasiIndexPasien = findViewById(R.id.validasiIndexPasien);
        validasiNIK = findViewById(R.id.validasiNIK);
        txtIndexPasien = findViewById(R.id.txtIndexPasien);
        txtNIK = findViewById(R.id.txtNIK);
        btnLogin = findViewById(R.id.btnLogin);
        txtRegistrasi = findViewById(R.id.txtRegister);

        // jika tombol login diklik
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IndexPasien = txtIndexPasien.getText().toString().trim();
                NIK = txtNIK.getText().toString().trim();

                if ( IndexPasien.isEmpty() ) {
                    validasiIndexPasien.setError("Index harus diisi!");
                } else if ( NIK.isEmpty() ) {
                    validasiNIK.setError("NIK harus diisi!");
                } else {
                    auth_pasien(IndexPasien, NIK);
                }
            }
        });

        // jika tombol register diklik
        txtRegistrasi.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                // sintak untuk pindah activity
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(intent);
            }
        });
    }

    // method login
    private void auth_pasien(final String IndexPasien, final String NIK){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("login");
                    if (success.equals("1")) {
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            String nama_pasien = jsonObject1.getString("pas_nama").trim();
                            String nik_pasien = jsonObject1.getString("pas_nik").trim();
                            String kk_pasien = jsonObject1.getString("pas_kk").trim();
                            String alamat_pasien = jsonObject1.getString("pas_alamat");
                            String telepon_pasien = jsonObject1.getString("pas_telepon").trim();
                            String lahir_pasien = jsonObject1.getString("pas_lahir").trim();
                            String agama_pasien = jsonObject1.getString("pas_agama").trim();
                            String pendidikan_pasien = jsonObject1.getString("pas_pendidikan").trim();
                            String kelamin_pasien = jsonObject1.getString("pas_kelamin").trim();
                            String darah_pasien = jsonObject1.getString("pas_darah").trim();
                            String pekerjaan_pasien = jsonObject1.getString("pas_pekerjaan").trim();

                            sessionManager.createSession(IndexPasien, nama_pasien, nik_pasien, kk_pasien,
                                                         alamat_pasien, telepon_pasien, lahir_pasien,
                                                         agama_pasien, pendidikan_pasien, kelamin_pasien,
                                                         darah_pasien, pekerjaan_pasien);

                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    } else {
                        Toast.makeText(LoginActivity.this, "Index dan NIK tidak ditemukan! ", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(LoginActivity.this, "Error login : " + e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        },
        new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginActivity.this, "Error login : " + error.toString(), Toast.LENGTH_SHORT) .show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username", IndexPasien);
                // sesuaikan dengan $_POST pada PHP
                params.put("password", NIK);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
