package com.example.puskesmassumbersari;

import java.io.Serializable;

public class AntreanAndaItem implements Serializable {
    String anda_nomor;

    public AntreanAndaItem(String anda_nomor) {
        this.anda_nomor = anda_nomor;
    }

    public String getAnda_nomor() { return anda_nomor; }

    @Override
    public String toString() {
        return "AntreanItem(" + "anda_nomor='" + anda_nomor + '\'' + ')';
    }
}
