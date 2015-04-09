package io.intercom.eclipsesample;

import io.intercom.android.sdk.Intercom;
import io.intercom.android.sdk.identity.Registration;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * ------------------------------------------------------------------------------------------------
 * ------------------------------------------------------------------------------------------------
 * Created by Intercom on 23/03/15.
 * ------------------------------------------------------------------------------------------------
 * Setting Up
 * ------------------------------------------------------------------------------------------------
 * This is a sample application to help with Intercom Android Eclispe setup
 * You will need to add your Api Key to the SampleApplication
 * You will also need to add either an email or user id (THIS USER WILL BE REGISTERED IN YOUR APP)
 * ------------------------------------------------------------------------------------------------
 * Usage
 * ------------------------------------------------------------------------------------------------
 * 1. Open the app
 * 2. Tap the Open Intercom button to open up the SDK
 * ------------------------------------------------------------------------------------------------
 * ------------------------------------------------------------------------------------------------
 */
public class MainActivity extends ActionBarActivity implements OnClickListener {
    //----------------------------------------------------------------------------------------------
    //MAKE SURE YOU GO TO THE SampleApplication TO CHANGE APIKEY AND APPID
    //----------------------------------------------------------------------------------------------
    //YOU MUST USE ONE OF THESE TO CREATE A SESSION
    private static final String YOUR_EMAIL = "";
    private static final String YOUR_USER_ID = "";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        if (!TextUtils.isEmpty(YOUR_USER_ID)) {
            Intercom.client().registerIdentifiedUser(new Registration().withUserId(YOUR_USER_ID));
        } else if (!TextUtils.isEmpty(YOUR_EMAIL)) {
            Intercom.client().registerIdentifiedUser(new Registration().withEmail(YOUR_EMAIL));
        } else {
            Log.d("REGISTRATION_ERROR", "No email or user id");
        }
        Button button = (Button) findViewById(R.id.intercomButton);
        button.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


	@Override
	public void onClick(View v) {
		Intercom.client().displayConversationsList();
	}
}
