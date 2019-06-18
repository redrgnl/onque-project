package com.example.puskesmassumbersari;

import java.io.Serializable;

public class AntreanItem implements Serializable {
    String running_nomor, last_nomor;

    public AntreanItem(String running_nomor, String last_nomor) {
        this.running_nomor = running_nomor;
        this.last_nomor = last_nomor;
    }

    public String getRunning_nomor() { return running_nomor; }

    public String getLast_nomor() { return getLast_nomor(); }

    @Override
    public String toString() {
        return "AntreanItem('" + running_nomor + '\'' + " dari " + '\'' + last_nomor + '\'' + ')';
    }
}
