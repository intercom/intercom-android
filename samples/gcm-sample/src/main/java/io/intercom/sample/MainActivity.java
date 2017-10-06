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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //----------------------------------------------------------------------------------------------
    // Make sure you go to SampleApplication.java to set your app ID and API key
    //----------------------------------------------------------------------------------------------
    private static final String USER_ID = "123456";

    //----------------------------------------------------------------------------------------------
    // If you use Identity Verification you will need to include HMAC
    // We suggest taking these values from your app. You may need to change USER_ID above to match your HMAC
    //----------------------------------------------------------------------------------------------
    private static final String YOUR_HMAC = "";

    private TextView unreadCountView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (TextUtils.isEmpty(SampleApplication.YOUR_APP_ID)
                || TextUtils.isEmpty(SampleApplication.YOUR_API_KEY)) {
            findViewById(R.id.not_initialized).setVisibility(View.VISIBLE);
        } else {
            //If you have provided a HMAC and data try begin secure session
            if (!TextUtils.isEmpty(YOUR_HMAC)) {
                Intercom.client().setUserHash(YOUR_HMAC);
            }

            //Enable default launcher
            Intercom.client().setLauncherVisibility(Intercom.Visibility.VISIBLE);
            //Register a user with Intercom
            Intercom.client().registerIdentifiedUser(Registration.create().withUserId(USER_ID));
            //Custom launcher
            Button messengerButton = findViewById(R.id.messenger_button);
            messengerButton.setOnClickListener(this);

            //Set the unread count
            unreadCountView = findViewById(R.id.unread_counter);
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
        Intercom.client().handlePushMessage();
    }
}
