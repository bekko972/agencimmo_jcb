package com.example.utilisateur.agencimmojcb;

import android.app.Application;
import android.content.Context;

/**
 * Created by Utilisateur on 03/04/2018.
 */
public class agencimmojcb972 extends Application {
    private static Context context;

    public void onCreate() {
        super.onCreate();
        agencimmojcb972.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return agencimmojcb972.context;
    }
}
