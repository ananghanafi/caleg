package com.tetracreasoft.caleg;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by AnangHanafi on 04/11/2018.
 */

public class Arraylist extends ArrayAdapter<AmbilData> {
    private Activity context;
    private List<AmbilData> ambilDataList;

    public Arraylist(@NonNull Activity context, List<AmbilData> ambilDataList) {
        super(context, R.layout.item_list, ambilDataList);
        this.context = context;
        this.ambilDataList = ambilDataList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View itemView = inflater.inflate(R.layout.item_list, null, true);
        TextView namaRT = (TextView) itemView.findViewById(R.id.namaList);
        TextView pesanT = (TextView) itemView.findViewById(R.id.suaraSayaList);
        TextView namaT = (TextView) itemView.findViewById(R.id.suaraSahList);
        TextView alamatT = (TextView) itemView.findViewById(R.id.suaratdkList);
        TextView alamatP = (TextView) itemView.findViewById(R.id.suarajmlList);
        AmbilData ambilData = ambilDataList.get(position);
        namaRT.setText(ambilData.getNama());
        pesanT.setText("Suara saya: " + ambilData.getSuara());
        namaT.setText("Suara sah: " + ambilData.getSah());
        alamatT.setText("Suara tidak sah: " + ambilData.getTidaksah());
        alamatP.setText("Jumlah Pemilih: " + ambilData.getJmlPemilih());
        return itemView;
    }
}

