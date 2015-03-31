package io.intercom.gcmsample;

import android.app.Application;

import io.intercom.android.sdk.Intercom;

public class SampleApplication extends Application {
    //CHANGE THESE VALUES
    private final String YOUR_API_KEY = "<YOUR_API_KEY>";
    private final String YOUR_APP_ID = "<YOUR_APP_ID>";

    @Override public void onCreate() {
        super.onCreate();
        Intercom.initialize(this, YOUR_API_KEY, YOUR_APP_ID);
    }
}
