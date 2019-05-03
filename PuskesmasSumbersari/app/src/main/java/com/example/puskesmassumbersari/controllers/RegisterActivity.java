package com.example.puskesmassumbersari.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import android.support.design.widget.TextInputLayout;
import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.puskesmassumbersari.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    private EditText txtIDPasien, txtNamaPasien, txtPassword, txtKonfirmasiPassword;
    private TextInputLayout validasiIDPasien, validasiNamaPasien, validasiPassword, validasiKonfirmasiPassword;
    private ProgressBar loading;
    private Button btnRegister;

    private static String URL = "http://10.10.3.60/api_android/sumbersarisehat/Pasien/registerPasien.php";

    private String id_pasien, nama_pasien, password, konfirmasi_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtIDPasien = findViewById(R.id.txtIDPasien);
        txtNamaPasien = findViewById(R.id.txtNamaPasien);
        txtPassword = findViewById(R.id.txtPassword);
        txtKonfirmasiPassword = findViewById(R.id.txtKonfirmasiPassword);

        validasiIDPasien = findViewById(R.id.validasiIDPasien);
        validasiNamaPasien = findViewById(R.id.validasiNamaPasien);
        validasiPassword = findViewById(R.id.validasiPassword);
        validasiKonfirmasiPassword = findViewById(R.id.validasiKonfirmasiPassword);

        btnRegister = findViewById(R.id.btnRegister);
        loading = findViewById(R.id.loading);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id_pasien = txtIDPasien.getText().toString().trim();
                nama_pasien = txtNamaPasien.getText().toString().trim();
                password = txtPassword.getText().toString().trim();
                konfirmasi_password = txtKonfirmasiPassword.getText().toString().trim();

                if ( id_pasien.isEmpty() ) {
                    validasiIDPasien.setError("ID Pasien harus diisi!");
                } else if( nama_pasien.isEmpty() ) {
                    validasiNamaPasien.setError("Nama Pasien harus diisi!");
                } else if( password.isEmpty() ) {
                    validasiPassword.setError("Password harus diisi");
                } else if( !konfirmasi_password.equals(password) ) {
                    validasiPassword.setError("Konfirmasi password harus sama");
                } else {
                    Registrasi();
                }
            }
        });
    }

    private void Registrasi() {
        loading.setVisibility(View.VISIBLE);
        btnRegister.setVisibility(View.GONE);
        id_pasien = this.txtIDPasien.getText().toString().trim();
        nama_pasien = this.txtNamaPasien.getText().toString().trim();
        password = this.txtPassword.getText().toString().trim();
        konfirmasi_password = this.txtKonfirmasiPassword.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(StringRequest.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");

                    if( success.equals("1") ) {
                        Toast.makeText(RegisterActivity.this, "Register Success!", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(RegisterActivity.this, "Register Error : " + e.toString(), Toast.LENGTH_SHORT).show();
                    loading.setVisibility(View.GONE);
                    btnRegister.setVisibility(View.VISIBLE);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(RegisterActivity.this, "Register Error : " + error.toString(), Toast.LENGTH_SHORT).show();
                loading.setVisibility(View.GONE);
                btnRegister.setVisibility(View.VISIBLE);
            }
        }) {
            @Override
            protected Map<String, String> getParams () throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("id_pasien", id_pasien);
                params.put("nama_pasien", nama_pasien);
                params.put("password", password);
                return  params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

}
