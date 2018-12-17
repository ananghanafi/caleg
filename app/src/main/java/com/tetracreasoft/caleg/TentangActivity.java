package com.tetracreasoft.caleg;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TentangActivity extends AppCompatActivity {
    TextView telp1, telp2, telp3, telp4, mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang);
        telp1 = (TextView) findViewById(R.id.telp1);

        telp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:085339151177")));
            }
        });

    }
}
