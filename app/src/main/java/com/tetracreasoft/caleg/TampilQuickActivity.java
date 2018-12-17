package com.tetracreasoft.caleg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TampilQuickActivity extends AppCompatActivity {
    private int suarasayad,suarasahd, suaratdksahd, suarapemilihd;
    TextView suarasayat, suarasaht, suaratdksaht, suarapemiliht;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_quick);

        suarasayat = (TextView) findViewById(R.id.suaraSayaf);
        suarasaht = (TextView) findViewById(R.id.suaraSahf);
        suaratdksaht = (TextView) findViewById(R.id.suaraTidakSahf);
        suarapemiliht = (TextView) findViewById(R.id.suaraPemilihf);

        suarasayad = getIntent().getExtras().getInt("suarasaya");
        suarasahd = getIntent().getExtras().getInt("suarasah");
        suaratdksahd = getIntent().getExtras().getInt("suaratidak");
        suarapemilihd = getIntent().getExtras().getInt("suarapemilih");

        suarasayat.setText(" " + suarasayad);
        suarasaht.setText(""+suarasahd);
        suaratdksaht.setText(""+suaratdksahd);
        suarapemiliht.setText(""+suarapemilihd);
    }
}
