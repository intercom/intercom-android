package com.intercom.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import io.intercom.android.sdk.Intercom
import io.intercom.android.sdk.identity.Registration
import io.intercom.android.sdk.push.IntercomPushClient

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val registerBtn = findViewById<Button>(R.id.btn_register)
        registerBtn.setOnClickListener {
            if (API_KEY.isBlank() or APP_ID.isBlank()) {
                Toast.makeText(this, "Please fix this!", Toast.LENGTH_SHORT)
            } else {
                val registration = Registration.create().withUserId("123")
                Intercom.client().registerIdentifiedUser(registration)
                Intercom.client().setLauncherVisibility(Intercom.VISIBLE)
            }
        }
    }
}