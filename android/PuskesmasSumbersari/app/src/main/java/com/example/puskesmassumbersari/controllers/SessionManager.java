package com.example.puskesmassumbersari.controllers;

import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SessionManager {
    // Shared Preferences
    private static SharedPreferences pref;

    // Editor for Shared preferences
    Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "PuskesmasSumbersari";

    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";

    // Make variable public to access from outside class
    public static final String KEY_INDEX_PASIEN = "pas_index";
    public static final String KEY_NIK_PASIEN = "pas_nik";
    public static final String KEY_KK_PASIEN = "pas_kk";
    public static final String KEY_ALAMAT_PASIEN = "pas_alamat";
    public static final String KEY_TELEPON_PASIEN = "pas_telepon";
    public static final String KEY_LAHIR_PASIEN = "pas_lahir";
    public static final String KEY_AGAMA_PASIEN = "pas_agama";
    public static final String KEY_PENDIDIKAN_PASIEN = "pas_pendidikan";
    public static final String KEY_KELAMIN_PASIEN = "pas_kelamin";
    public static final String KEY_DARAH_PASIEN = "pas_darah";
    public static final String KEY_PEKERJAAN_PASIEN = "pas_pekerjaan";
    public static final String KEY_NAMA_PASIEN = "pas_nama";

    // Constructor
    public SessionManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    /**
     * Create login session
     * */
    public void createSession(String index_pasien, String nama_pasien, String nik_pasien,
                              String kk_pasien, String alamat_pasien, String telepon_pasien,
                              String lahir_pasien, String agama_pasien, String pendidikan_pasien,
                              String kelamin_pasien, String darah_pasien, String pekerjaan_pasien){

        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);

        // Storing index_pasien in pref
        editor.putString(KEY_INDEX_PASIEN, index_pasien);

        // Storing data profil pasien in pref
        editor.putString(KEY_NAMA_PASIEN, nama_pasien);
        editor.putString(KEY_NIK_PASIEN, nik_pasien);
        editor.putString(KEY_KK_PASIEN, kk_pasien);
        editor.putString(KEY_ALAMAT_PASIEN, alamat_pasien);
        editor.putString(KEY_TELEPON_PASIEN, telepon_pasien);
        editor.putString(KEY_LAHIR_PASIEN, lahir_pasien);
        editor.putString(KEY_AGAMA_PASIEN, agama_pasien);
        editor.putString(KEY_PENDIDIKAN_PASIEN, pendidikan_pasien);
        editor.putString(KEY_KELAMIN_PASIEN, kelamin_pasien);
        editor.putString(KEY_DARAH_PASIEN, darah_pasien);
        editor.putString(KEY_PEKERJAAN_PASIEN, pekerjaan_pasien);

        // commit changes
        editor.commit();
    }

    /**
     * Check login method wil check user login status
     * If false it will redirect user to login page
     * Else won't do anything
     * */
    public void checkLogin(){
        // Check login status
        if(!this.isLoggedIn()){
            // user is not logged in redirect him to Login Activity
            Intent i = new Intent(_context, LoginActivity.class);
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Staring Login Activity
            _context.startActivity(i);
        }

    }

    /**
     * Get stored session data
     * */
    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        // index pasien
        user.put(KEY_INDEX_PASIEN, pref.getString(KEY_INDEX_PASIEN, null));

        // data profil pasien
        user.put(KEY_NAMA_PASIEN, pref.getString(KEY_NAMA_PASIEN, null));
        user.put(KEY_NIK_PASIEN, pref.getString(KEY_NIK_PASIEN, null));
        user.put(KEY_KK_PASIEN, pref.getString(KEY_KK_PASIEN, null));
        user.put(KEY_ALAMAT_PASIEN, pref.getString(KEY_ALAMAT_PASIEN, null));
        user.put(KEY_TELEPON_PASIEN, pref.getString(KEY_TELEPON_PASIEN, null));
        user.put(KEY_LAHIR_PASIEN, pref.getString(KEY_LAHIR_PASIEN, null));
        user.put(KEY_AGAMA_PASIEN, pref.getString(KEY_AGAMA_PASIEN, null));
        user.put(KEY_PENDIDIKAN_PASIEN, pref.getString(KEY_PENDIDIKAN_PASIEN, null));
        user.put(KEY_KELAMIN_PASIEN, pref.getString(KEY_KELAMIN_PASIEN, null));
        user.put(KEY_DARAH_PASIEN, pref.getString(KEY_DARAH_PASIEN, null));
        user.put(KEY_PEKERJAAN_PASIEN, pref.getString(KEY_PEKERJAAN_PASIEN, null));


        // return user
        return user;
    }

    /**
     * Clear session details
     * */
    public void logoutUser(){
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();

        // After logout redirect user to Loing Activity
        Intent i = new Intent(_context, LoginActivity.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        _context.startActivity(i);
    }

    /**
     * Quick check for login
     * **/
    // Get Login State
    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }



}