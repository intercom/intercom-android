package com.intercom.sample

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.intercom.android.sdk.Intercom
import io.intercom.android.sdk.identity.Registration

class MainActivity : AppCompatActivity() {
    var launcherVisibility = false
    val registerBtn by lazy { findViewById<Button>(R.id.btn_register) }
    val launcherVisibiltyBtn by lazy { findViewById<Button>(R.id.btn_toggle_launcher_visibility) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerBtn.setOnClickListener {
            if (API_KEY.isBlank() or APP_ID.isBlank()) {
                Toast.makeText(this, "Please fix this!", Toast.LENGTH_SHORT)
            } else {
                val registration = Registration.create().withUserId("123")
                Intercom.client().registerIdentifiedUser(registration)
                Intercom.client().setLauncherVisibility(Intercom.VISIBLE)
                launcherVisibiltyBtn.visibility = View.VISIBLE
                launcherVisibility = true
            }
        }
        launcherVisibiltyBtn.setOnClickListener {
            if (launcherVisibility)
                Intercom.client().setLauncherVisibility(Intercom.GONE)
            else
                Intercom.client().setLauncherVisibility(Intercom.VISIBLE)
            launcherVisibility = launcherVisibility.not()
        }
    }
}