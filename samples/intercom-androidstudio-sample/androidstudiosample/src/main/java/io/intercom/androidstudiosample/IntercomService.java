package io.intercom.androidstudiosample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import io.intercom.android.sdk.Intercom;
import io.intercom.android.sdk.identity.Registration;

/**
 * Created by Intercom on 13/05/15.
 * Copyright (c) 2015 Intercom. All rights reserved.
 */
public class IntercomService extends Service {

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override public void onCreate() {
        super.onCreate();
        Intercom.client().registerIdentifiedUser(new Registration().withEmail("dale@intercom.io"));
        Log.d("SERVICE", "onCreate called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("SERVICE", "onDestroy called");
    }
}