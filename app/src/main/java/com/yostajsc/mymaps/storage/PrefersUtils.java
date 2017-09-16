package com.yostajsc.mymaps.storage;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Ham on 9/16/2017.
 */

public final class PrefersUtils {

    public static final  String FILE_NAME="mymaps";


    //Stores <key><value> (String) to SharePreferences
    public static void store(Context context,String key,String value){
        SharedPreferences preferences= context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);

        SharedPreferences.Editor editor= preferences.edit();
        editor.putString(key, value);
        //editor.commit();// Writes data to storage immediately
        editor.apply();//Writes data to storage in background
    }

    //Stores <key><value> (Int) to SharePreferences
    public static void store(Context context,String key,int value){
        SharedPreferences preferences= context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);

        SharedPreferences.Editor editor= preferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static String getString(Context context,String key){
        SharedPreferences preferences = context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
        return preferences.getString(key,""); // defValue = ""
    }

    public static int getInt(Context context,String key){
        SharedPreferences preferences =context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
        return preferences.getInt(key,-1); //defValue = -1
    }
}
