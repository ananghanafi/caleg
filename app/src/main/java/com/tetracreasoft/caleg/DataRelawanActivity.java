package com.tetracreasoft.caleg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataRelawanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_relawan);
        String[] namaguru = new String[]{
                "Nama Relawan ",
                "Nama Relawan ", "Nama Relawan ", "Nama Relawan ",
                "Nama Relawan ", "Nama Relawan ", "Nama Relawan ",


        };

        int[] imagekiri = new int[]{
                R.mipmap.ic_logo_round,
                R.mipmap.ic_logo_round,
                R.mipmap.ic_logo_round,
                R.mipmap.ic_logo_round,
                R.mipmap.ic_logo_round,
                R.mipmap.ic_logo_round,
                R.mipmap.ic_logo_round,
                R.mipmap.ic_logo_round,

        };
        List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < 7; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();

            hm.put("namaguru", namaguru[i]);
            hm.put("imagekiri", Integer.toString(imagekiri[i]));
            list.add(hm);


        }
        String[] dari = {"imagekiri", "namaguru"};
        int[] ke = {R.id.imagekiri, R.id.nama};
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, list, R.layout.list_pengaturan, dari, ke);
        ListView listView = (ListView) findViewById(R.id.list_pengaturanid);
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent page = new Intent(DataRelawanActivity.this, DetailDataActivity.class);
                        startActivity(page);
                        break;
                    case 1:
                        Intent page1 = new Intent(DataRelawanActivity.this, DetailDataActivity.class);
                        startActivity(page1);
                        break;
                    case 2:
                        Intent page2 = new Intent(DataRelawanActivity.this, DetailDataActivity.class);
                        startActivity(page2);
                        break;
                    case 3:
                        Intent page3 = new Intent(DataRelawanActivity.this, DetailDataActivity.class);
                        startActivity(page3);
                        break;
                    case 4:
                        Intent page4 = new Intent(DataRelawanActivity.this, DetailDataActivity.class);
                        startActivity(page4);
                        break;
                    case 5:
                        Intent page5 = new Intent(DataRelawanActivity.this, DetailDataActivity.class);
                        startActivity(page5);
                        break;
                    case 6:
                        Intent page6 = new Intent(DataRelawanActivity.this, DetailDataActivity.class);
                        startActivity(page6);
                        break;
                }
            }
        });
    }
}
