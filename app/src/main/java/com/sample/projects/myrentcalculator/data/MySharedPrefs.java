package com.sample.projects.myrentcalculator.data;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Chyron-MACBOOK on 10/12/18.
 */

public class MySharedPrefs {

    private Context context;
    public static String KEY_PREFS_UNIT = "key_units";
    public static String KEY_JSON_UNIT = "json_units";
    public static String KEY_UNITS = "units";

    public MySharedPrefs(Context context) {
        this.context = context;
    }

    public void writeSharedPrefs(String keyPrefsName,
                                 String json,
                                 String keyJson) {
        SharedPreferences sharedPrefs = context.getSharedPreferences(keyPrefsName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString(keyJson, json).apply();
    }

    public String readSharedPreferences(String keyPrefsName,
                                  String keyJson) {
        String json = null;
        SharedPreferences sharedPrefs = context.getSharedPreferences(keyPrefsName, Context.MODE_PRIVATE);
        return sharedPrefs.getString(keyJson, json);
    }

    public void clearSharedPreferences(String keyPrefsName) {
        SharedPreferences sharedPrefs = context.getSharedPreferences(keyPrefsName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.clear().apply();
    }
}

