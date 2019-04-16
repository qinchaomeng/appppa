package com.example.volleystudio;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Time:2019/4/16
 * Author:秦超蒙
 * Description:
 */
public class MyApp extends Application {
    private static RequestQueue queue;


    @Override
    public void onCreate() {
        super.onCreate();
         queue = Volley.newRequestQueue(getApplicationContext());
    }
    public static RequestQueue getVolley(){
        return queue;
    }
}
