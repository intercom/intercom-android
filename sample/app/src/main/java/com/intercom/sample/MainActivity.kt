package com.intercom.sample

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.Group
import io.intercom.android.sdk.Intercom
import io.intercom.android.sdk.identity.Registration

class MainActivity : AppCompatActivity() {
    var launcherVisibility = false
    val regIdentifiedBtn by lazy { findViewById<Button>(R.id.btn_register_identified) }
    val regUnidentifiedBtn by lazy { findViewById<Button>(R.id.btn_register_unidentified) }
    val launcherVisibiltyBtn by lazy { findViewById<Button>(R.id.btn_toggle_launcher_visibility) }
    val unregisterUserBtn by lazy {findViewById<Button>(R.id.btn_unregister_user)}
    val userGroup by lazy { findViewById<Group>(R.id.group_user)}
    val editTextEmail by lazy { findViewById<EditText>(R.id.editTxt_email_input)}

    private fun validateAPIKey() : Boolean {
        if (API_KEY.isBlank() or APP_ID.isBlank()) {
            Toast.makeText(this, "Please update your API Key and App ID in SampleApplication!", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        regUnidentifiedBtn.setOnClickListener {
            if(validateAPIKey()) {
                Intercom.client().registerUnidentifiedUser()
                Intercom.client().setLauncherVisibility(Intercom.VISIBLE)
                userGroup.visibility = View.VISIBLE
                regUnidentifiedBtn.visibility = View.GONE
                launcherVisibility = true
            }
        }

        regIdentifiedBtn.setOnClickListener {
            if(validateAPIKey()) {
                val email = editTextEmail.text.toString()
                if(email.isNotBlank()) {
                    val registration = Registration.create().withEmail(email)
                    Intercom.client().registerIdentifiedUser(registration)
                    Intercom.client().setLauncherVisibility(Intercom.VISIBLE)
                    userGroup.visibility = View.VISIBLE
                    regUnidentifiedBtn.visibility = View.GONE
                    regIdentifiedBtn.visibility = View.GONE
                    launcherVisibility = true

                } else {
                    AlertDialog.Builder(this)
                        .setMessage("Email can't be blank!")
                        .setPositiveButton("Ok") { _, _ -> }
                        .create()
                        .show()
                }
            }
        }

        launcherVisibiltyBtn.setOnClickListener {
            if (launcherVisibility)
                Intercom.client().setLauncherVisibility(Intercom.GONE)
            else
                Intercom.client().setLauncherVisibility(Intercom.VISIBLE)
            launcherVisibility = launcherVisibility.not()
        }

        unregisterUserBtn.setOnClickListener {
            Intercom.client().logout()
            userGroup.visibility = View.GONE
            regUnidentifiedBtn.visibility = View.VISIBLE
            regIdentifiedBtn.visibility = View.VISIBLE
        }

    }

}