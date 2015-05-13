package io.intercom.gcmsample;

import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;

import java.io.IOException;

import io.intercom.android.sdk.Intercom;
import io.intercom.android.sdk.identity.Registration;

/**
 * ------------------------------------------------------------------------------------------------
 * ------------------------------------------------------------------------------------------------
 * Created by Intercom on 23/02/15.
 * ------------------------------------------------------------------------------------------------
 * Setting Up
 * ------------------------------------------------------------------------------------------------
 * This is a sample application to help with Intercom Android GCM setup
 * You will need to add your Api Key, App Id i nthe SampleApplication file
 * You will also need to change the GCM sender Id and add either an email or user id (THIS USER WILL BE REGISTERED IN YOUR APP)
 * If you have enabled secure mode you will need to provide hmac and data
 * ------------------------------------------------------------------------------------------------
 * Usage
 * ------------------------------------------------------------------------------------------------
 * 1. Open the app on a gcm enabled device (no simulators/emulators without google play services)
 * 2. Tap the register button
 * 3. Wait for register button to turn grey and GCM Status should say Registered
 * 4. Tap the Intercom logo on the top right to open the In App Messenger
 * 5. If the session is working you should see your inbox
 * ------------------------------------------------------------------------------------------------
 * Error checking
 * ------------------------------------------------------------------------------------------------
 * Make sure you have no filters on and search using GCM_ISSUE
 * Report any issue on Intercom or on our Github repo
 * ------------------------------------------------------------------------------------------------
 * ------------------------------------------------------------------------------------------------
 */
public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    //----------------------------------------------------------------------------------------------
    //MAKE SURE YOU GO TO THE SampleApplication TO CHANGE APIKEY AND APPID
    //----------------------------------------------------------------------------------------------
    //CHANGE THIS VALUE
    private static final String YOUR_SENDER_ID = "<YOUR_SENDER_ID>";

    //YOU MUST USE ONE OF THESE TO CREATE A SESSION
    private static final String YOUR_EMAIL = "";
    private static final String YOUR_USER_ID = "";

    //IF YOU USE SECURE MODE YOU WILL NEED TO INCLUDE H_MAC AND DATA
    //I WOULD TAKE THE VALUES FROM YOUR ACTUAL APP
    private static final String YOUR_HMAC = "";
    private static final String YOUR_DATA = "";

    private static final String GCM_DETAILS = "gcmDetails";

    private static final String PROPERTY_REG_ID = "registration_id";
    private static final String PROPERTY_APP_VERSION = "app_version";

    //used for retrying a failed gcm registration
    private static final long MAX_RETRY = 80000;
    private static long retryTime = 10000;

    private GoogleCloudMessaging gcm;
    private String regId;

    private Button registerButton;
    private TextView registrationStatus;

    private SharedPreferences prefs;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs = getSharedPreferences(GCM_DETAILS, MODE_PRIVATE);

        registerButton = (Button) findViewById(R.id.register_button);
        registerButton.setOnClickListener(this);

        registrationStatus = (TextView) findViewById(R.id.status);

        //if you have provided a hmac and data try begin secure session
        if (!TextUtils.isEmpty(YOUR_HMAC) && !TextUtils.isEmpty(YOUR_DATA)) {
            Intercom.client().setSecureMode(YOUR_HMAC, YOUR_DATA);
        }

        //if we have stored regId we can try to handle the intent data
        if (prefs.contains(PROPERTY_REG_ID)) {
            //even though we have a registrationId we send it up to the backend again
            setUpPush();
            //pass us the data of the intent and if it is an intercom gcm intent
            //we will store the conversation id and open the sdk when it is prepared
            //there may be a short wait in the current version, this will not exist in v1.0
            Intercom.client().openGCMMessage(getIntent().getData());
            //disable the register button
            registerButton.setEnabled(false);
        }
    }

    @Override public void onClick(View v) {
        //if you have provided a user id register user with it, otherwise we will use email
        if (!TextUtils.isEmpty(YOUR_USER_ID)) {
            Intercom.client().registerIdentifiedUser(new Registration().withUserId(YOUR_USER_ID));
        } else if (!TextUtils.isEmpty(YOUR_EMAIL)) {
            Intercom.client().registerIdentifiedUser(new Registration().withEmail(YOUR_EMAIL));
        } else {
            Log.d("REGISTRATION_ERROR", "No email or user id");
        }

        registerButton.setEnabled(false);
        setUpPush();
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_intercom) {
            Intercom.client().displayConversationsList();
        }
        return super.onOptionsItemSelected(item);
    }

    //==========================
    // region GCM
    //==========================
    private void setUpPush() {
        //make sure we have google play services available,
        //without it we can't use push
        if (checkPlayServices()) {
            gcm = GoogleCloudMessaging.getInstance(this);
            //check if we have an existing gcm registrationId
            regId = getRegistrationId();

            //if we don't have a registrationId we need to get one
            //otherwise we use the one from our prefs
            if (regId.isEmpty()) {
                registerInBackground();
            } else {
                //set text to success
                registrationStatus.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
                registrationStatus.setText(getResources().getString(R.string.gcm_status_enabled));
                sendRegistrationIdToBackend(regId);
            }
        } else {
            Log.d("GCM_ISSUE", "No valid Google Play Services APK found.");
        }
    }

    public boolean checkPlayServices() {
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        return resultCode == ConnectionResult.SUCCESS;
    }

    private String getRegistrationId() {
        String registrationId = prefs.getString(PROPERTY_REG_ID, "");
        if (registrationId.isEmpty()) {
            Log.d("GCM_ISSUE", "Registration ID not found.");
            return "";
        }
        int registeredVersion = prefs.getInt(PROPERTY_APP_VERSION, Integer.MIN_VALUE);
        int currentVersion = getAppVersion();
        if (registeredVersion != currentVersion) {
            Log.d("GCM_ISSUE", "App version changed.");
            return "";
        }
        return registrationId;
    }

    private int getAppVersion() {
        try {
            PackageInfo packageInfo = this.getPackageManager()
                    .getPackageInfo(this.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("Could not get package name: " + e);
        }
    }

    private void storeRegistrationId(String regId) {
        int appVersion = getAppVersion();

        Log.d("GCM_SUCCESS", "Saving regId on app version " + appVersion);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(PROPERTY_REG_ID, regId);
        editor.putInt(PROPERTY_APP_VERSION, appVersion);
        editor.apply();
    }

    private void registerInBackground() {
        new AsyncTask<Void, Void, Boolean>() {
            @Override protected Boolean doInBackground(Void... params) {
                String msg = "";
                Boolean result = false;

                try {
                    if (gcm == null) {
                        Log.d("GCM_ISSUE", "gcm object was null");
                        gcm = GoogleCloudMessaging.getInstance(MainActivity.this);
                    }
                    regId = gcm.register(YOUR_SENDER_ID);

                    if (!TextUtils.isEmpty(regId)) {
                        sendRegistrationIdToBackend(regId);
                        storeRegistrationId(regId);
                        result = true;
                    } else {
                        Log.d("GCM_ISSUE", "regId was null or empty");
                    }

                    Log.d("GCM_SUCCESS", "Current Device's Registration ID is: " + msg);
                } catch (IOException ex) {
                    Log.d("GCM_ISSUE", "Error :" + ex.getMessage());
                    //retry the registration after delay
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            registerInBackground();
                        }
                    }, retryTime);
                    //increase the time of wait period
                    if (retryTime < MAX_RETRY) {
                        retryTime *= 2;
                    }
                }
                return result;
            }

            @Override protected void onPostExecute(Boolean success) {
                if (success) {
                    registrationStatus.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
                    registrationStatus.setText(getResources().getString(R.string.gcm_status_enabled));
                }
            }
        }.execute(null, null, null);
    }

    private void sendRegistrationIdToBackend(String regId) {
        //enable push with your registration id, the package name and an app icon
        Intercom.client().setupGCM(regId, R.mipmap.ic_launcher);
    }
    //==========================
    // endregion
    //==========================
}
