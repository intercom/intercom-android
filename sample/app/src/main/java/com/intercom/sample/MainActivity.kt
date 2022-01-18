package com.intercom.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import io.intercom.android.sdk.Intercom
import io.intercom.android.sdk.identity.Registration
import io.intercom.android.sdk.push.IntercomPushClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(API_KEY.isBlank() or APP_ID.isBlank()){
            findViewById<TextView>(R.id.textview).text = "Please set App ID and Api Key in SampleApplication.kt"
        }else{
            val registration = Registration.create().withUserId("1234567")
            Intercom.client().registerIdentifiedUser(registration)
            Intercom.client().setLauncherVisibility(Intercom.VISIBLE)

            findViewById<TextView>(R.id.textview).text = "Intercom initialised successfully"
        }
    }
}