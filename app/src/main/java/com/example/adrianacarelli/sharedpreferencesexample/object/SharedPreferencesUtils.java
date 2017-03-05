package com.example.adrianacarelli.sharedpreferencesexample.object;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.adrianacarelli.sharedpreferencesexample.R;
import com.example.adrianacarelli.sharedpreferencesexample.SharedPreferencesExample;

/**
 * Created by agsuser on 18/01/17.
 */

public class SharedPreferencesUtils {

    private static Context context = SharedPreferencesExample.getContext();
    private static final String TAG = SharedPreferencesUtils.class.getName();
    private static SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

    public static void setNome (String nome){

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(context.getString(R.string.preferences_nome), nome);

        editor.commit();
    }

    public static String getNome(){
        String nome = sharedPreferences.getString(context.getString(R.string.preferences_nome), "");

        return nome;
    }

    public static void setCognome(String cognome){

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(context.getString(R.string.preferences_cognome), cognome);

        editor.commit();
    }

    public static String getCognome(){
        String nome = sharedPreferences.getString(context.getString(R.string.preferences_cognome), "");

        return nome;
    }

    public static void setEmail(String email){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(context.getString(R.string.preferences_email), email);

        editor.commit();
    }

    public static String getEmail(){
        String email = sharedPreferences.getString(context.getString(R.string.preferences_email), "");

        return email;
    }

    public static void setPhone(String phone){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(context.getString(R.string.preferences_phone), phone);

        editor.commit();
    }

    public static String getPhone(){
        String phone = sharedPreferences.getString(context.getString(R.string.preferences_phone), "");

        return phone;

    }

}
