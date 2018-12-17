package com.tetracreasoft.caleg;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuickActivity extends AppCompatActivity {
    DatabaseReference namaCaleg;
    ProgressBar pbAll;
    ListView listView;
    List<AmbilData> ambilDataList;
    Arraylist adapter;
    int temData[];
    int i = 0;
    Intent k;
    int suarasaya = 0, suarasah = 0, suaratdksah = 0, suarapemilih = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick);
        temData = new int[120000];
        namaCaleg = FirebaseDatabase.getInstance().getReference("namaCalegCoba");
        listView = (ListView) findViewById(R.id.listViewPesan);
        pbAll = (ProgressBar) findViewById(R.id.pbAll);
        ambilDataList = new ArrayList<>();
        pbAll.setVisibility(View.VISIBLE);

        namaCaleg.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println("OnData Change");
                ambilDataList.clear();

                for (DataSnapshot pesanSnpshot : dataSnapshot.getChildren()) {
                    pbAll.setVisibility(View.GONE);
                    AmbilData ambilData = pesanSnpshot.getValue(AmbilData.class);
                    System.out.println("NO " + i + 1 + "Ambil Data " + ambilData);
                    ambilDataList.add(ambilData);
                    suarasaya += Integer.parseInt(ambilDataList.get(i).getSuara());
                    suarasah += Integer.parseInt(ambilDataList.get(i).getSah());
                    suaratdksah += Integer.parseInt(ambilDataList.get(i).getTidaksah());
                    suarapemilih += Integer.parseInt(ambilDataList.get(i).getJmlPemilih());
                    k = new Intent(QuickActivity.this, TampilQuickActivity.class);

                    k.putExtra("suarasaya", suarasaya);
                    k.putExtra("suarasah", suarasah);
                    k.putExtra("suaratidak", suaratdksah);
                    k.putExtra("suarapemilih", suarapemilih);
                    i++;
                    System.out.println("AmbildataList " + suarasaya);
                }
                //  Arraylist adapter = new Arraylist(RecycleActivity.this, ambilDataList);
                Collections.reverse(ambilDataList);
                adapter = new Arraylist(QuickActivity.this, ambilDataList);
                listView.setAdapter(adapter);

                System.out.println(" kclc " + adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hitung();
            }
        });

    }

    public void hitung() {
        System.out.println("AmbildataListCoba " + suarasaya);
//        for (int x = 0; x < i; x++) {
//            suarasaya += Integer.parseInt(ambilDataList.get(x).getSuara());
//            suarasah += Integer.parseInt(ambilDataList.get(x).getSah());
//            suaratdksah += Integer.parseInt(ambilDataList.get(x).getTidaksah());
//            suarapemilih += Integer.parseInt(ambilDataList.get(x).getJmlPemilih());
//        }


        startActivity(k);
    }
}
