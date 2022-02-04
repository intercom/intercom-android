package com.intercom.sample

import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Group
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import io.intercom.android.sdk.Intercom
import io.intercom.android.sdk.identity.Registration
import kotlinx.coroutines.flow.collect


class MainActivity : AppCompatActivity() {
    var launcherVisibility = false
    val regIdentifiedBtn by lazy { findViewById<Button>(R.id.btn_register_identified) }
    val regUnidentifiedBtn by lazy { findViewById<Button>(R.id.btn_register_unidentified) }
    val launcherVisibiltyBtn by lazy { findViewById<Button>(R.id.btn_toggle_launcher_visibility) }
    val unregisterUserBtn by lazy { findViewById<Button>(R.id.btn_unregister_user) }
    val userGroup by lazy { findViewById<Group>(R.id.group_user) }
    val displayGroup by lazy { findViewById<Group>(R.id.group_display) }
    val editTextEmail by lazy { findViewById<EditText>(R.id.editTxt_email_input) }
    val editUserIdEmail by lazy { findViewById<EditText>(R.id.txtEditUserID) }
    val displayHelpCenter by lazy { findViewById<Button>(R.id.btn_helpcenter) }
    val displayArticle by lazy { findViewById<Button>(R.id.btn_article) }
    val displayCarousel by lazy { findViewById<Button>(R.id.btn_carousel) }
    val mainLayout by lazy { findViewById<ConstraintLayout>(R.id.layout_main) }
    val mainViewModel by viewModels<MainViewModel>()

    private fun validateAPIKey(): Boolean {
        if (API_KEY.isBlank() or APP_ID.isBlank()) {
            Snackbar.make(mainLayout, "Missing App ID and/or API Key!", Snackbar.LENGTH_LONG).show()
            return false
        }
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launchWhenStarted {
            mainViewModel.btnState.collect {
                if (it.registrationVisibility) {
                    regIdentifiedBtn.visibility = View.VISIBLE
                    regUnidentifiedBtn.visibility = View.VISIBLE
                    userGroup.visibility = View.GONE
                    displayGroup.visibility = View.GONE
                } else {
                    regIdentifiedBtn.visibility = View.GONE
                    regUnidentifiedBtn.visibility = View.GONE
                    userGroup.visibility = View.VISIBLE
                    displayGroup.visibility = View.VISIBLE
                }
            }
        }


        regUnidentifiedBtn.setOnClickListener {
            if (validateAPIKey()) {
                Intercom.client().registerUnidentifiedUser()
                Intercom.client().setLauncherVisibility(Intercom.VISIBLE)
                mainViewModel.btnState.value = ViewState(registrationVisibility = false)
            }
        }

        regIdentifiedBtn.setOnClickListener {
            if (validateAPIKey()) {
                val email = editTextEmail.text.toString()
                val userId = editUserIdEmail.text.toString()

                if (userId.isNotBlank()) {
                    val registration = Registration.create().withUserId(userId)
                    Intercom.client().registerIdentifiedUser(registration)
                    Intercom.client().setLauncherVisibility(Intercom.VISIBLE)
                    mainViewModel.btnState.value = ViewState(registrationVisibility = false)
                } else if (email.isNotBlank()) {
                    val registration = Registration.create().withEmail(email)
                    Intercom.client().registerIdentifiedUser(registration)
                    Intercom.client().setLauncherVisibility(Intercom.VISIBLE)
                    mainViewModel.btnState.value = ViewState(registrationVisibility = false)
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
            mainViewModel.btnState.value = ViewState(registrationVisibility = true)
        }

        displayHelpCenter.setOnClickListener {
            Intercom.client().displayHelpCenter()
        }

        displayArticle.setOnClickListener {
            displayInputDialog("Article", "Enter Article ID. (e.g. 1560406)") {
                Intercom.client().displayArticle(it)
            }
        }

        displayCarousel.setOnClickListener {
            displayInputDialog("Carousel", "Enter Carousel ID. (e.g. 11543787)") {
                Intercom.client().displayCarousel(it)
            }
        }
    }

    private fun displayInputDialog(title: String, hint: String, positiveAction: (String) -> Unit) {
        val input = EditText(this)
        input.hint = hint
        input.inputType = InputType.TYPE_CLASS_TEXT

        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setView(input)

        builder.setNegativeButton("Cancel") { dialog, _ -> dialog.cancel() }
        builder.setPositiveButton("Open") { dialog, _ -> positiveAction(input.text.toString()) }
        builder.show()
    }

}