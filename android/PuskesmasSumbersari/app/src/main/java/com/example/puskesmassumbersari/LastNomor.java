package com.example.puskesmassumbersari;

import java.io.Serializable;

public class LastNomor implements Serializable {
    String last_nomor;

    public LastNomor(String last_nomor) {
        this.last_nomor = last_nomor;
    }

    public String getLast_nomor() { return last_nomor; }

    @Override
    public String toString() {
        return "AntreanItem(" + "last_nomor='" + last_nomor + '\'' + ')';
    }
}
