package com.intercom.sample

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.intercom.sample.components.TextInputAlertDialogController
import io.intercom.android.sdk.Intercom
import io.intercom.android.sdk.IntercomContent
import io.intercom.android.sdk.IntercomError
import io.intercom.android.sdk.IntercomSpace
import io.intercom.android.sdk.IntercomStatusCallback
import io.intercom.android.sdk.identity.Registration
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MainVm(private val prefDataStore: DataStore<Preferences>) : ViewModel() {
    val dialogController = TextInputAlertDialogController()
    private val keyUserRegistered = booleanPreferencesKey("user_registered")

    val userRegistrationStatus: Flow<Boolean> = prefDataStore.data.map { preferences ->
        preferences[keyUserRegistered] ?: false
    }

    private val userRegistrationCallback = object : IntercomStatusCallback {
        override fun onFailure(intercomError: IntercomError) {
            setUserRegistrationStatus(false)
        }

        override fun onSuccess() {
            setUserRegistrationStatus(true)
        }
    }

    init {
        viewModelScope.launch {
            userRegistrationStatus.collect { userRegistered ->
                Intercom.client().setLauncherVisibility(
                    if (userRegistered) Intercom.VISIBLE else Intercom.GONE
                )
            }
        }
    }

    fun loginIdentifiedUserWithId(id: String) {
        Intercom.client().loginIdentifiedUser(
            userRegistration = Registration().withUserId(id),
            intercomStatusCallback = userRegistrationCallback
        )
    }

    fun loginIdentifiedUserWithEmail(email: String) {
        Intercom.client().loginIdentifiedUser(
            userRegistration = Registration().withEmail(email),
            intercomStatusCallback = userRegistrationCallback
        )
    }

    fun loginUnidentifiedUser() {
        Intercom.client().loginUnidentifiedUser(
            intercomStatusCallback = userRegistrationCallback
        )
    }

    fun logout() {
        Intercom.client().logout()
        setUserRegistrationStatus(false)
    }

    fun openMessage() = Intercom.client().present(IntercomSpace.Messages)
    fun openHelpCenter() = Intercom.client().present(IntercomSpace.HelpCenter)
    fun showArticle() {
        dialogController.show("Article id") {
            Intercom.client().presentContent(IntercomContent.Article(id = it))
        }
    }

    fun showCarousel() {
        dialogController.show("Carousel id") {
            Intercom.client().presentContent(IntercomContent.Carousel(id = it))
        }
    }

    fun showSurvey() {
        dialogController.show("Survey id") {
            Intercom.client().presentContent(IntercomContent.Survey(id = it))
        }
    }

    fun showCollections() {
        dialogController.show("Collection ids") {
            Intercom.client()
                .presentContent(IntercomContent.HelpCenterCollections(ids = it.split(",")))
        }
    }

    fun setUserRegistrationStatus(status: Boolean) {
        viewModelScope.launch {
            prefDataStore.edit { preferences -> preferences[keyUserRegistered] = status }
        }
    }

    companion object {
        fun getVmFactory(dataStore: DataStore<Preferences>): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(
                    modelClass: Class<T>
                ): T {
                    return MainVm(dataStore) as T
                }
            }
    }

}
