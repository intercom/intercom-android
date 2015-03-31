package io.intercom.androidstudiosample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import io.intercom.android.sdk.Intercom;
import io.intercom.android.sdk.identity.Registration;

/**
 * ------------------------------------------------------------------------------------------------
 * ------------------------------------------------------------------------------------------------
 * Created by Intercom on 31/03/15.
 * ------------------------------------------------------------------------------------------------
 * Setting Up
 * ------------------------------------------------------------------------------------------------
 * This is a sample application to help with Intercom integration in Android Studio apps
 * You will need to add your Api Key and App Id to the SampleApplication
 * You will also need to add either an email or user id (THIS USER WILL BE REGISTERED IN YOUR APP)
 * If you have enabled secure mode you will need to provide hmac and data
 * ------------------------------------------------------------------------------------------------
 * Usage
 * ------------------------------------------------------------------------------------------------
 * 1. Open the app
 * 2. Tap the register button
 * 3. Tap the intercom button on the top right to see the inbox or be brought to compose a new message
 * ------------------------------------------------------------------------------------------------
 * Error checking
 * ------------------------------------------------------------------------------------------------
 * Make sure you have no filters on
 * Report any issue on Intercom or on our Github repo
 * ------------------------------------------------------------------------------------------------
 * ------------------------------------------------------------------------------------------------
 */
public class MainActivity extends ActionBarActivity implements View.OnClickListener {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerButton = (Button) findViewById(R.id.register_button);
        registerButton.setOnClickListener(this);

        //if you have provided a hmac and data try begin secure session
        if (!TextUtils.isEmpty(YOUR_HMAC) && !TextUtils.isEmpty(YOUR_DATA)) {
            Intercom.client().setSecureMode(YOUR_HMAC, YOUR_DATA);
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_intercom) {
            Intercom.client().displayConversationsList();
        }
        return super.onOptionsItemSelected(item);
    }
}
