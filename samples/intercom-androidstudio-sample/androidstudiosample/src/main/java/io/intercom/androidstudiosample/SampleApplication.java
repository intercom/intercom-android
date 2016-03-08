package io.intercom.androidstudiosample;

import android.app.Application;

import io.intercom.android.sdk.Intercom;

/**
 * Created by Intercom on 31/03/15.
 * Copyright (c) 2015 Intercom. All rights reserved.
 */
public class SampleApplication extends Application {
    //CHANGE THESE VALUES
    private static final String YOUR_API_KEY = "<INTERCOM_API_KEY>";
    private static final String YOUR_APP_ID = "<INTERCOM_APP_ID>";

    @Override public void onCreate() {
        super.onCreate();
        Intercom.initialize(this, YOUR_API_KEY, YOUR_APP_ID);
    }
}
