package com.example.cameraalbumtest;

import android.util.Log;

public class L {
    private static final String TAG="okhttp";
    private static boolean debug=true;
    public static void e(String msg){
        if(debug){
            Log.e(TAG,msg);
        }

    }
}
