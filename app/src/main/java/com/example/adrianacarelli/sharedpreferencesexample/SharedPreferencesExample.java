package com.example.adrianacarelli.sharedpreferencesexample;

import android.app.Application;
import android.content.Context;

/**
 * Created by agsuser on 18/01/17.
 */

public class SharedPreferencesExample extends Application {

    private static SharedPreferencesExample instance;

    public static SharedPreferencesExample getInstance(){

        return instance;
    }

    @Override
    public void onCreate() {

        instance = this;
        super.onCreate();
    }

    public static Context getContext(){
        return instance;
    }
}
