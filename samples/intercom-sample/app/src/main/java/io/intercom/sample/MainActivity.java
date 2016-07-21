package io.intercom.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import io.intercom.android.sdk.Intercom;
import io.intercom.android.sdk.UnreadConversationCountListener;
import io.intercom.android.sdk.identity.Registration;

/**
 * ------------------------------------------------------------------------------------------------
 * ------------------------------------------------------------------------------------------------
 * Setting Up
 * ------------------------------------------------------------------------------------------------
 * This is a sample application to demonstrate how to integrate Intercom in a simple app.
 * You will need to add your Api Key and App Id to the SampleApplication
 * You will also need to add either an email or user id (THIS USER WILL BE REGISTERED IN YOUR APP)
 * If you have enabled secure mode you will need to provide hmac and data
 *
 * If you want to enable GCM in the test app simply provide your sender_id (project number in google-services.json)
 * in the strings.xml file inside the tag intercom_gcm_sender_id
 * ------------------------------------------------------------------------------------------------
 * Usage
 * ------------------------------------------------------------------------------------------------
 * 1. Open the app
 * 2. Tap the register button
 * 3. Tap the chat with us button to open the messenger
 * 4. Send a new message to that user to see the unread badge update on the custom launcher and the in app arrive
 * ------------------------------------------------------------------------------------------------
 * Error checking
 * ------------------------------------------------------------------------------------------------
 * Check logcat for any errors, make sure you have no filters turned on. It can help to switch
 * logcat to Verbose.
 * Report any issue on Intercom or on our Github repo
 * ------------------------------------------------------------------------------------------------
 * ------------------------------------------------------------------------------------------------
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //----------------------------------------------------------------------------------------------
    //Make sure you go to SampleApplication.java to set your App Id and API Key
    //----------------------------------------------------------------------------------------------
    private static final String USER_ID = "123456";

    //----------------------------------------------------------------------------------------------
    //If you use secure mode you will need to include HMAC and data
    //We suggest taking these values from your app. You may need to change USER_ID above
    //to match your HMAC values
    //----------------------------------------------------------------------------------------------
    private static final String YOUR_HMAC = "";
    private static final String YOUR_DATA = "";

    private TextView unreadCountView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (TextUtils.isEmpty(SampleApplication.YOUR_APP_ID)
                || TextUtils.isEmpty(SampleApplication.YOUR_API_KEY)) {
            findViewById(R.id.not_initialized).setVisibility(View.VISIBLE);
        } else {
            //if you have provided a hmac and data try begin secure session
            if (!TextUtils.isEmpty(YOUR_HMAC) && !TextUtils.isEmpty(YOUR_DATA)) {
                Intercom.client().setSecureMode(YOUR_HMAC, YOUR_DATA);
            }

            //enable default launcher
            Intercom.client().setLauncherVisibility(Intercom.Visibility.VISIBLE);
            //register a user with intercom
            Intercom.client().registerIdentifiedUser(Registration.create().withUserId(USER_ID));
            //Custom launcher
            Button messengerButton = (Button) findViewById(R.id.messenger_button);
            messengerButton.setOnClickListener(this);

            //set the unread count
            unreadCountView = (TextView) findViewById(R.id.unread_counter);
            int unreadCount = Intercom.client().getUnreadConversationCount();
            unreadCountView.setText(String.valueOf(unreadCount));
            setBadgeVisibility(unreadCount, unreadCountView);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.messenger_button:
                Intercom.client().displayConversationsList();
                break;
        }
    }

    private final UnreadConversationCountListener unreadConversationCountListener = new UnreadConversationCountListener() {
        @Override public void onCountUpdate(int unreadCount) {
            setBadgeVisibility(unreadCount, unreadCountView);
            unreadCountView.setText(String.valueOf(unreadCount));
        }
    };

    private void setBadgeVisibility(int unreadCount, TextView unreadCountView) {
        int visibility = unreadCount == 0 ? View.INVISIBLE : View.VISIBLE;
        unreadCountView.setVisibility(visibility);
    }

    @Override
    protected void onPause() {
        super.onPause();

        Intercom.client().removeUnreadConversationCountListener(unreadConversationCountListener);
    }

    @Override
    public void onResume() {
        super.onResume();

        Intercom.client().addUnreadConversationCountListener(unreadConversationCountListener);
        Intercom.client().openGcmMessage();
    }
}
