/*
 * SoleoLocalSearchAPI
 *
 * This file was automatically generated for SOLEO by APIMATIC BETA v2.0 on 03/01/2016
 */
package com.soleo.lsapi;

import android.content.Context;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class Configuration {
    //The base Uri for API calls
    public static String baseUri = "https://trialapi.soleo.com";
    
    //API Key from developer.soleo.com
	private static String aPIKey = "$YOUR_KEY";


    //retains status whether we have already initialized
    private static boolean initialized = false;
    private static RequestQueue requestQueue = null;

    //Initialization of configuration
    public static void initialize(Context context){
        if(initialized)
            throw new IllegalStateException("Already initialized");

        requestQueue = Volley.newRequestQueue(context);
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo app = packageManager.getApplicationInfo(packageName, PackageManager.GET_META_DATA);
            Bundle bundle = app.metaData;

            aPIKey = bundle.getString("apikey");

            initialized = true;
        }
        catch (Exception ex){
            throw new IllegalStateException("Unable to initialize", ex);
        }
    }

    // volley request queue needs to be initialized before use
    public static RequestQueue getRequestQueue() {
        if(!initialized)
            throw new IllegalStateException("Must initialize before accessing request queue");
        return requestQueue;
    }


    public static String getAPIKey() {
        if(!initialized)
            throw new IllegalStateException("Must initialize configuration before use");

        return aPIKey;
    }
}
