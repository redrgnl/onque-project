package com.example.puskesmassumbersari;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends ArrayAdapter<AntreanItem> {
    private List<AntreanItem> antreanItemList;

    private Context context;

    public ListAdapter(List<AntreanItem> antreanItemList, Context context) {
        super(context, R.layout.nomor_view, antreanItemList);
        this.antreanItemList = antreanItemList;
        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View listViewItem = inflater.inflate(R.layout.nomor_view, parent, false);

        TextView textViewNo = listViewItem.findViewById(R.id.textViewNo);
        TextView jumlahAntrean = listViewItem.findViewById(R.id.jumlahAntrean);

        AntreanItem antreanItem = this.antreanItemList.get(position);

        textViewNo.setText(antreanItem.getRunning_nomor());
        jumlahAntrean.setText(antreanItem.getLast_nomor());

        return listViewItem;
    }
}
