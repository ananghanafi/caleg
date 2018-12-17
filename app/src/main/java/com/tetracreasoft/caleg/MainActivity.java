package com.tetracreasoft.caleg;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView telp1, telp2, telp3, telp4, mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CardView quick = (CardView) findViewById(R.id.quick);
        CardView vol = (CardView) findViewById(R.id.vol);
        CardView bantuan = (CardView) findViewById(R.id.bantuan);
        CardView tentang = (CardView) findViewById(R.id.tentang);
        CardView profile = (CardView) findViewById(R.id.profile);
        telp2 = (TextView) findViewById(R.id.telp2);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        quick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tambah = new Intent(MainActivity.this, QuickActivity.class);
                startActivity(tambah);
            }
        });
        vol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pemasangan = new Intent(MainActivity.this, DataRelawanActivity.class);
                startActivity(pemasangan);
            }
        });
        bantuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pemasangan = new Intent(MainActivity.this, BantuanActivity.class);
                startActivity(pemasangan);
            }
        });
        tentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pemasangan = new Intent(MainActivity.this, TentangActivity.class);
                startActivity(pemasangan);
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pemasangan = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(pemasangan);
            }
        });


        telp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent whatsappIntent = new Intent(Intent.ACTION_VIEW);
                whatsappIntent.setPackage("com.whatsapp");
                whatsappIntent.setData(Uri.parse("https://api.whatsapp.com/send?phone=6285339151177&text=Assalamu'alaikum"));
                startActivity(whatsappIntent);
               // startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:085339151177")));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            //PackageManager
            //  Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
            //    whatsappIntent.setType("text/plain");
            //   whatsappIntent.setPackage("com.whatsapp");
            // whatsappIntent.putExtra(Intent.EXTRA_TEXT, "https://api.whatsapp.com/send?phone=6285339151177" );
//            Intent whatsappIntent = new Intent(Intent.ACTION_VIEW);
//            whatsappIntent.setPackage("com.whatsapp");
//            whatsappIntent.setData(Uri.parse("https://api.whatsapp.com/send?phone=6285339151177&text=Assalamu'alaikum"));
//            startActivity(whatsappIntent);

              startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:085339151177")));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
