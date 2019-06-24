package com.example.puskesmassumbersari;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


public class AmbilAntreanActivity extends Activity {

    Spinner spinnerPoli;
    Button btnAntre, btnBatal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambil_antrean);

        spinnerPoli = (Spinner) findViewById(R.id.spinner_poli);
        spinnerPoli.setOnItemSelectedListener(new CustomOnItemSelectedListener());

        addAntrrean();

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

        spinnerPoli = (Spinner) findViewById(R.id.spinner_poli);
        btnAntre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AmbilAntreanActivity.this, "OnClickListener : " +
                        "\nPoli : " + String.valueOf(spinnerPoli.getSelectedItem()), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
