package com.example.puskesmassumbersari;

import java.io.Serializable;

public class AntreanAndaItem implements Serializable {
    String running_nomor, last_nomor, anda_nomor, anda_poli, anda_status;

    public AntreanAndaItem(String running_nomor, String last_nomor, String anda_nomor, String anda_poli, String anda_status) {
        this.running_nomor = running_nomor;
        this.last_nomor = last_nomor;
        this.anda_nomor = anda_nomor;
        this.anda_poli = anda_poli;
        this.anda_status = anda_status;
    }

    public String getRunning_nomor() { return running_nomor; }

    public String getLast_nomor() { return last_nomor; }

    public String getAnda_nomor() { return anda_nomor; }

    public String getAnda_poli() { return anda_poli; }

    public String getAnda_status() { return anda_status; }

    @Override
    public String toString() {
        return "AntreanItem(" + "running_nomor='" + '\'' + "last_nomor='" + '\'' + "anda_nomor='" + anda_nomor + '\''
                + "anda_poli='" + '\'' + anda_poli + "anda_status='" + anda_status + ')';
    }
}
