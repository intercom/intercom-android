package io.intercom.gcmsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;

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
 * You will need to visit https://developers.google.com/cloud-messaging/android/client to download
 * your configuration file. Use the following 'io.intercom.gcmsample' as the package name and then
 * copy the file into gcmsample directory.
 * You will need to add your Api Key, App Id in the SampleApplication file
 * You will also need to add either an email or user id (THIS USER WILL BE REGISTERED IN YOUR APP)
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
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //----------------------------------------------------------------------------------------------
    //MAKE SURE YOU GO TO THE SampleApplication TO CHANGE APIKEY AND APPID
    //----------------------------------------------------------------------------------------------

    //YOU MUST USE ONE OF THESE TO CREATE A SESSION
    private static final String YOUR_EMAIL = "";
    private static final String YOUR_USER_ID = "";

    //IF YOU USE SECURE MODE YOU WILL NEED TO INCLUDE H_MAC AND DATA
    //I WOULD TAKE THE VALUES FROM YOUR ACTUAL APP
    private static final String YOUR_HMAC = "";
    private static final String YOUR_DATA = "";

    private Button registerButton;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerButton = (Button) findViewById(R.id.register_button);
        registerButton.setOnClickListener(this);

        //if you have provided a hmac and data try begin secure session
        if (!TextUtils.isEmpty(YOUR_HMAC) && !TextUtils.isEmpty(YOUR_DATA)) {
            Intercom.client().setSecureMode(YOUR_HMAC, YOUR_DATA);
        }

        //pass us the data of the intent and if it is an intercom gcm intent
        //we will open up the conversation in our in-app messenger
        Intercom.client().openGCMMessage(getIntent());
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
        //without it we can't receive push notifications
        if (checkPlayServices()) {
            // Start IntentService to register this application with GCM.
            Intent intent = new Intent(this, RegistrationIntentService.class);
            startService(intent);
        }
    }

    public boolean checkPlayServices() {
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        return resultCode == ConnectionResult.SUCCESS;
    }
}
