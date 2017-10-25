package com.example.volleyimagedownloader;

import android.app.Application;

/**
 * Created by ashwin on 2/6/17.
 */

public class AppController extends Application {

    public static final String TAG = AppController.class.getSimpleName();

    private static AppController mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static synchronized AppController getInstance() {
        return mInstance;
    }
}
