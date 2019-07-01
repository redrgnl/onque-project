package com.example.puskesmassumbersari.controllers;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity{

    private Spinner spinnerAgama, spinnerPendidikan, spinnerJenisKelamin, spinnerGolDarah, spinnerPekerjaan;

    private String[]

            arrPendidikan = {"-- Pilih Pendidikan --", "Tidak Sekolah", "TK", "SD/MI", "SMP/MTs", "SMA/MA/SMK", "S1/D4", "S2", "S3"},
            arrAgama = {"-- Pilih Agama --", "Islam", "Kristen", "Hindu", "Budha", "Katolik", "Konghucu"},

            arrJenisKelamin = {"-- Pilih Jenis Kelamin --", "Laki - laki", "Perempuan"},
            arrGolDarah = {"-- Pilih Golongan Darah --", "AB", "A", "B", "O"},
            arrPekerjaan = {"-- Pilih Pekerjaan Anda --", "Guru/Dosen", "Wiraswasta"};

    private EditText txtIndexPasien, txtNIK, txtNama, txtKepalaKeluarga, txtAlamat, txtNoTelp,
            txtTglLahir;
    private TextInputLayout validasiIndexPasien, validasiNIK, validasiNama, validasiKepalaKeluarga,
            validasiAlamat, validasiNoTelp, validasiTglLahir, validasiAgama, validasiPendidikan,
            validasiJenisKelamin, validasiGolDarah, validasiPekerjaan;
    private ProgressBar loading;
    private Button btnRegister;

    private static String URL = Server.URL + "api/app_register/index_post";

    private String indexPasien, NIK, nama, kepalaKeluarga, alamat, noTelp, tglLahir, agama,
            pendidikan, jenisKelamin, golDarah, pekerjaan;
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

        // Inisiasi variabel-variabel edit text dengan id edit text dari layout activity_register.xml
        txtIndexPasien = findViewById(R.id.txtIndexPasien);
        txtNIK = findViewById(R.id.txtNIK);
        txtNama = findViewById(R.id.txtNama);
        txtKepalaKeluarga = findViewById(R.id.txtKepalaKeluarga);
        txtAlamat = findViewById(R.id.txtAlamat);
        txtNoTelp = findViewById(R.id.txtNoTelp);
        txtTglLahir = findViewById(R.id.txtTglLahir);
        spinnerAgama = findViewById(R.id.spinnerAgama);
        spinnerPendidikan = findViewById(R.id.spinnerPendidikan);
        spinnerJenisKelamin = findViewById(R.id.spinnerJenisKelamin);
        spinnerGolDarah = findViewById(R.id.spinnerGolDarah);
        spinnerPekerjaan = findViewById(R.id.spinnerPekerjaan);

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
        spinnerPendidikan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position!=0) {
                    pendidikan = arrPendidikan[position];
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                // sometimes you need nothing here
            }
        });
        spinnerAgama.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position!=0) {
                    agama = arrAgama[position];
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                // sometimes you need nothing here
            }
        });

        spinnerJenisKelamin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position!=0) {
                    jenisKelamin = arrJenisKelamin[position];
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                // sometimes you need nothing here
            }
        });
        spinnerGolDarah.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position!=0) {
                    golDarah = arrGolDarah[position];
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                // sometimes you need nothing here
            }
        });
        spinnerPekerjaan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position!=0) {
                    pekerjaan = arrPekerjaan[position];
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                // sometimes you need nothing here
            }
        });

        ArrayAdapter<String> arrayPendidikan = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arrPendidikan);
        arrayPendidikan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPendidikan.setAdapter(arrayPendidikan);

        ArrayAdapter<String> arrayAgama = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arrAgama);
        arrayAgama.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAgama.setAdapter(arrayAgama);



        ArrayAdapter<String> arrayJenisKelamin = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arrJenisKelamin);
        arrayJenisKelamin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerJenisKelamin.setAdapter(arrayJenisKelamin);

        ArrayAdapter<String> arrayGolDarah = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arrGolDarah);
        arrayGolDarah.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGolDarah.setAdapter(arrayGolDarah);

        ArrayAdapter<String> arrayPekerjaan = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arrPekerjaan);
        arrayPekerjaan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPekerjaan.setAdapter(arrayPekerjaan);

        txtTglLahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog();
            }
        });

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
//                agama = spinnerAgama.getOnItemSelectedListener().toString().trim();
//                pendidikan = spinnerPendidikan.getOnItemSelectedListener().toString().trim();
//                jenisKelamin = spinnerJenisKelamin.getOnItemSelectedListener().toString().trim();
//                golDarah = spinnerGolDarah.getOnItemSelectedListener().toString().trim();
//                pekerjaan = spinnerPekerjaan.getOnItemSelectedListener().toString().trim();

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



    private void  showDateDialog(){
        Calendar newCalendar = Calendar.getInstance();

        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                txtTglLahir.setText(dateFormatter.format(newDate.getTime()));
            }
        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
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
//        agama = spinnerAgama.getOnItemSelectedListener().toString().trim();
//        pendidikan = spinnerPendidikan.getOnItemSelectedListener().toString().trim();
//        jenisKelamin = spinnerJenisKelamin.getOnItemSelectedListener().toString().trim();
//        golDarah = spinnerGolDarah.getOnItemSelectedListener().toString().trim();
//        pekerjaan = spinnerPekerjaan.getOnItemSelectedListener().toString().trim();

        StringRequest stringRequest = new StringRequest(StringRequest.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");

                    if ( success.equals("1") ) {
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
