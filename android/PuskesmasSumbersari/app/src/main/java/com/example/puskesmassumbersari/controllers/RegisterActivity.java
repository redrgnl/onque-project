package com.example.puskesmassumbersari.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.content.Intent;

import android.support.design.widget.TextInputLayout;
import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.puskesmassumbersari.R;
import com.example.puskesmassumbersari.config.Server;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    private EditText txtIndexPasien, txtNIK, txtNama, txtKepalaKeluarga, txtAlamat, txtNoTelp,
            txtTglLahir, txtAgama, txtPendidikan, txtJenisKelamin, txtGolDarah, txtPekerjaan;
    private TextInputLayout validasiIndexPasien, validasiNIK, validasiNama, validasiKepalaKeluarga,
            validasiAlamat, validasiNoTelp, validasiTglLahir, validasiAgama, validasiPendidikan,
            validasiJenisKelamin, validasiGolDarah, validasiPekerjaan;
    private ProgressBar loading;
    private Button btnRegister;

    private static String URL = Server.URL + "app_api/index_post";

    private String indexPasien, NIK, nama, kepalaKeluarga, alamat, noTelp, tglLahir, agama,
            pendidikan, jenisKelamin, golDarah, pekerjaan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Inisiasi variabel-variabel edit text dengan id edit text dari layout activity_register.xml
        txtIndexPasien = findViewById(R.id.txtIndexPasien);
        txtNIK = findViewById(R.id.txtNIK);
        txtNama = findViewById(R.id.txtNama);
        txtKepalaKeluarga = findViewById(R.id.txtKepalaKeluarga);
        txtAlamat = findViewById(R.id.txtAlamat);
        txtNoTelp = findViewById(R.id.txtNoTelp);
        txtTglLahir = findViewById(R.id.txtTglLahir);
        txtAgama = findViewById(R.id.txtAgama);
        txtPendidikan = findViewById(R.id.txtPendidikan);
        txtJenisKelamin = findViewById(R.id.txtJenisKelamin);
        txtGolDarah = findViewById(R.id.txtGolDarah);
        txtPekerjaan = findViewById(R.id.txtPekerjaan);

        // Inisiasi variabel-variabel validasi dengan id validasi dari layout activity_register.xml
        validasiIndexPasien = findViewById(R.id.validasiIndexPasien);
        validasiNIK = findViewById(R.id.validasiNIK);
        validasiNama = findViewById(R.id.validasiNama);
        validasiKepalaKeluarga = findViewById(R.id.validasiKepalaKeluarga);
        validasiAlamat = findViewById(R.id.validasiAlamat);
        validasiNoTelp = findViewById(R.id.validasiNoTelp);
        validasiTglLahir = findViewById(R.id.validasiTglLahir);
        validasiAgama = findViewById(R.id.validasiAgama);
        validasiPendidikan = findViewById(R.id.validasiPendidikan);
        validasiJenisKelamin = findViewById(R.id.validasiJenisKelamin);
        validasiGolDarah = findViewById(R.id.validasiGolDarah);
        validasiPekerjaan = findViewById(R.id.validasiPekerjaan);

        btnRegister = findViewById(R.id.btnRegister);
        loading = findViewById(R.id.loading);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                indexPasien = txtIndexPasien.getText().toString().trim();
                NIK = txtNIK.getText().toString().trim();
                nama = txtNama.getText().toString().trim();
                kepalaKeluarga = txtKepalaKeluarga.getText().toString().trim();
                alamat = txtAlamat.getText().toString().trim();
                noTelp = txtNoTelp.getText().toString().trim();
                tglLahir = txtTglLahir.getText().toString().trim();
                agama = txtAgama.getText().toString().trim();
                pendidikan = txtPendidikan.getText().toString().trim();
                jenisKelamin = txtJenisKelamin.getText().toString().trim();
                golDarah = txtGolDarah.getText().toString().trim();
                pekerjaan = txtPekerjaan.getText().toString().trim();

                if ( indexPasien.isEmpty() ) {
                    validasiIndexPasien.setError("Index pasien harus diisi!");
                } else if( NIK.isEmpty() ) {
                    validasiNIK.setError("NIK harus diisi!");
                } else if( nama.isEmpty() ) {
                    validasiNama.setError("Nama harus diisi");
                } else if( kepalaKeluarga.isEmpty() ) {
                    validasiKepalaKeluarga.setError("Kepala keluarga harus diisi!");
                } else if( alamat.isEmpty() ) {
                    validasiAlamat.setError("Alamat harus diisi");
                } else if( noTelp.isEmpty() ) {
                    validasiNoTelp.setError("Nomor telepon harus diisi!");
                } else if( tglLahir.isEmpty() ) {
                    validasiTglLahir.setError("Tanggal lahir harus diisi");
                } else if( agama.isEmpty() ) {
                    validasiAgama.setError("Agama harus diisi!");
                } else if( pendidikan.isEmpty() ) {
                    validasiPendidikan.setError("Pendidikan harus diisi");
                } else if( golDarah.isEmpty() ) {
                    validasiGolDarah.setError("Golongan darah harus diisi!");
                } else if( pekerjaan.isEmpty() ) {
                    validasiPekerjaan.setError("Pekerjaan harus diisi");
                } else {
                    Registrasi();
                }
            }
        });
    }

    private void Registrasi() {
        loading.setVisibility(View.VISIBLE);
        btnRegister.setVisibility(View.GONE);
        indexPasien = txtIndexPasien.getText().toString().trim();
        NIK = txtNIK.getText().toString().trim();
        nama = txtNama.getText().toString().trim();
        kepalaKeluarga = txtKepalaKeluarga.getText().toString().trim();
        alamat = txtAlamat.getText().toString().trim();
        noTelp = txtNoTelp.getText().toString().trim();
        tglLahir = txtTglLahir.getText().toString().trim();
        agama = txtAgama.getText().toString().trim();
        pendidikan = txtPendidikan.getText().toString().trim();
        jenisKelamin = txtJenisKelamin.getText().toString().trim();
        golDarah = txtGolDarah.getText().toString().trim();
        pekerjaan = txtPekerjaan.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(StringRequest.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");

                    if( success.equals("1") ) {
                        Toast.makeText(RegisterActivity.this, "Registrasi Sukses!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(RegisterActivity.this, "Registrasi Error : " + e.toString(), Toast.LENGTH_SHORT).show();
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
                params.put("pas_index", indexPasien);
                params.put("pas_nik", NIK);
                params.put("pas_nama", nama);
                params.put("pas_kk", kepalaKeluarga);
                params.put("pas_alamat", alamat);
                params.put("pas_telepon", noTelp);
                params.put("pas_lahir", tglLahir);
                params.put("pas_agama", agama);
                params.put("pas_pendidikan", pendidikan);
                params.put("pas_kelamin", jenisKelamin);
                params.put("pas_darah", golDarah);
                params.put("pas_pekerjaan", pekerjaan);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

}
