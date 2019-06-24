package com.example.puskesmassumbersari;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ListAdapterAntrianAnda extends ArrayAdapter<AntreanAndaItem> {
    private List<AntreanAndaItem> antreanAndaItemList;

    private Context context;

    public ListAdapterAntrianAnda(List<AntreanAndaItem> antreanAndaItemList, Context context) {
        super(context, R.layout.view_antrian_anda, antreanAndaItemList);
        this.antreanAndaItemList = antreanAndaItemList;
        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View listViewItem = inflater.inflate(R.layout.view_antrian_anda, parent, false);

        TextView textViewPoliData = listViewItem.findViewById(R.id.textViewPoliData);
        TextView textViewNoAntrianSekarang = listViewItem.findViewById(R.id.textViewNoAntrianSekarang);
        TextView textViewNoAntrianTerakhir = listViewItem.findViewById(R.id.textViewNoAntrianTerakhir);
        TextView textViewNoAntrianAndaData = listViewItem.findViewById(R.id.textViewNoAntrianAndaData);
        TextView textViewStatusData = listViewItem.findViewById(R.id.textViewStatusData);
        TextView textViewTanggalCheckIn = listViewItem.findViewById(R.id.tanggalCheckIn);

        AntreanAndaItem antreanAndaItem = this.antreanAndaItemList.get(position);

        textViewPoliData.setText(antreanAndaItem.getAnda_poli());
        textViewNoAntrianSekarang.setText(antreanAndaItem.getRunning_nomor());
        textViewNoAntrianTerakhir.setText(antreanAndaItem.getLast_nomor());
        textViewNoAntrianAndaData.setText(antreanAndaItem.getAnda_nomor());
        textViewStatusData.setText(antreanAndaItem.getAnda_status());

        return listViewItem;
    }
}
