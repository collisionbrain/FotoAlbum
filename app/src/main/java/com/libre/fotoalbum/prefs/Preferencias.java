package com.libre.fotoalbum.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.libre.fotoalbum.utils.Utilerias;

import java.io.Serializable;

/**
 * Created by hgallardo on 07/03/17.
 */

public class Preferencias {

    private SharedPreferences preferences;

    public Preferencias(Context context ){
        this.preferences  = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void saveData (String key,  String data){
        SharedPreferences.Editor editor = this.preferences.edit();
        editor.putString(key,data);
        editor.commit();
    }
    public void saveDataInt (String key,  int value){
        SharedPreferences.Editor editor = this.preferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }
    public void saveDataObjet(String key,  Serializable data){
        SharedPreferences.Editor editor = this.preferences.edit();
        editor.putString(key, Utilerias.objectToString(data));
        editor.commit();
    }


    public String loadData(String key){
        return this.preferences.getString(key, null);
    }

    public int loadDataInt(String key){
        return this.preferences.getInt(key, 0);
    }
    public Serializable loadDatObjeta(String key){
        return Utilerias.stringToObject(this.preferences.getString(key, null));
    }


    public void clearPreferences(){
        SharedPreferences.Editor editor = this.preferences.edit();
        editor.clear();
        editor.commit();
        return;
    }
    public void clearPreference(String key){
        SharedPreferences.Editor editor = this.preferences.edit();
        editor.remove(key);
        editor.commit();
        return;
    }



}