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
import com.example.puskesmassumbersari.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    // deklarasi objek
    TextInputLayout validasiIDPasien, validasiPassword;
    EditText txtIDPasien, txtPassword;
    Button btnLogin;
    TextView txtRegistrasi;

    // deklarasi variabel
    String id_pasien, password;

    // deklarasi variabel alamat host
    // setting terlebih dahulu supaya antara laptop dan android jadi satu jaringan
    public static String URL = "http://192.168.56.1/api_android/sumbersarisehat/Pasien/loginPasien.php";

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sessionManager = new SessionManager(this);

        // inisialisasi variabel objek
        validasiIDPasien = findViewById(R.id.validasiIDPasien);
        validasiPassword = findViewById(R.id.validasiPassword);
        txtIDPasien = findViewById(R.id.txtIDPasien);
        txtPassword = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        txtRegistrasi = findViewById(R.id.txtRegister);

        // jika tombol login diklik
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id_pasien = txtIDPasien.getText().toString().trim();
                password = txtPassword.getText().toString().trim();

                if ( id_pasien.isEmpty() ) {
                    validasiIDPasien.setError("ID Pasien harus diisi!");
                } else if ( password.isEmpty() ) {
                    validasiIDPasien.setError("Password harus diisi!");
                } else {
                    auth_pasien(id_pasien, password);
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
    private void auth_pasien(final String id_pasien, final String password){
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
                            String nama_pasien = jsonObject1.getString("nama_pasien").trim();
                            sessionManager.createSession(id_pasien, nama_pasien);
                            Toast.makeText(LoginActivity.this, "Login berhasil ! \n Nama : " + nama_pasien, Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(LoginActivity.this, "ID Pasien dan Password tidak ditemukan! ", Toast.LENGTH_SHORT).show();
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
            protected Map<String, String> getParams() throws AuthFailureError { Map<String, String> params = new HashMap<>();
            params.put("id_pasien", id_pasien);
            // sesuaikan dengan $_POST pada PHP
            params.put("password", password);
            return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}