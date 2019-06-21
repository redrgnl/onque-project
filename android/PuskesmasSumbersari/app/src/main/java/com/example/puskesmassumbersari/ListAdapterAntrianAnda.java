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
        super(context, R.layout.view_antrian_anda2, antreanAndaItemList);
        this.antreanAndaItemList = antreanAndaItemList;
        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View listViewItem = inflater.inflate(R.layout.view_nomor, parent, false);

        TextView noAntrianAnda = listViewItem.findViewById(R.id.noAntrianAnda);

        AntreanAndaItem antreanAndaItem = this.antreanAndaItemList.get(position);

        noAntrianAnda.setText(antreanAndaItem.getAnda_nomor());

        return listViewItem;
    }
}
