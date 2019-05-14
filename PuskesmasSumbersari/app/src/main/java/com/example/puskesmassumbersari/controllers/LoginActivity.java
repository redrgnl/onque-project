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
import android.content.Intent;

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
    TextInputLayout validasiUsername, validasiPassword;
    EditText txtUsername, txtPassword;
    Button btnLogin;
    TextView txtRegistrasi;

    // deklarasi variabel
    String username, password;

    // deklarasi variabel alamat host
    // setting terlebih dahulu supaya antara laptop dan android jadi satu jaringan
    public static String URL = Server.URL + "app_login/index_login";

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sessionManager = new SessionManager(this);

        // inisialisasi variabel objek
        validasiUsername = findViewById(R.id.validasiUsername);
        validasiPassword = findViewById(R.id.validasiPassword);
        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        txtRegistrasi = findViewById(R.id.txtRegister);

        // jika tombol login diklik
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = txtUsername.getText().toString().trim();
                password = txtPassword.getText().toString().trim();

                if ( username.isEmpty() ) {
                    validasiUsername.setError("Username harus diisi!");
                } else if ( password.isEmpty() ) {
                    validasiPassword.setError("Password harus diisi!");
                } else {
                    auth_pasien(username, password);
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
    private void auth_pasien(final String username, final String password){
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
                            sessionManager.createSession(username, nama_pasien);
                            //Toast.makeText(LoginActivity.this, "Login berhasil ! \n Nama : " + nama_pasien, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    } else {
                        Toast.makeText(LoginActivity.this, "Username dan Password tidak ditemukan! ", Toast.LENGTH_SHORT).show();
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
            params.put("username", username);
            // sesuaikan dengan $_POST pada PHP
            params.put("password", password);
            return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
