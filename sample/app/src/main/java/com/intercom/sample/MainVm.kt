package com.intercom.sample

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.intercom.sample.components.SelfServeAlertDialogController
import io.intercom.android.sdk.Intercom
import io.intercom.android.sdk.IntercomContent
import io.intercom.android.sdk.IntercomError
import io.intercom.android.sdk.IntercomSpace
import io.intercom.android.sdk.IntercomStatusCallback
import io.intercom.android.sdk.UserAttributes
import io.intercom.android.sdk.identity.Registration
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

val Context.dataStore by preferencesDataStore("settings")

class MainVm(private val prefDataStore: DataStore<Preferences>) : ViewModel(), SelfServeActions {
    val dialogController = SelfServeAlertDialogController()
    private val keyUserRegistered = booleanPreferencesKey("user_registered")

    val userRegistrationStatus: Flow<Boolean> = prefDataStore.data.map { preferences ->
        preferences[keyUserRegistered] ?: false
    }

    private val _effects = MutableSharedFlow<MainEffects>()
    val effects = _effects.asSharedFlow()

    private val userRegistrationCallback = object : IntercomStatusCallback {
        override fun onFailure(intercomError: IntercomError) {
            setUserRegistrationStatus(false)
            showToast(intercomError.errorMessage)
        }

        override fun onSuccess() {
            setUserRegistrationStatus(true)
            showToast("User Registered")
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

    override fun openMessage() = Intercom.client().present(IntercomSpace.Messages)
    override fun openHelpCenter() = Intercom.client().present(IntercomSpace.HelpCenter)
    override fun showArticle() {
        dialogController.show("Article id") {
            Intercom.client().presentContent(IntercomContent.Article(id = it))
        }
    }

    override fun showCarousel() {
        dialogController.show("Carousel id") {
            Intercom.client().presentContent(IntercomContent.Carousel(id = it))
        }
    }

    override fun showSurvey() {
        dialogController.show("Survey id") {
            Intercom.client().presentContent(IntercomContent.Survey(id = it))
        }
    }

    override fun showCollections() {
        dialogController.show("Collection ids") {
            Intercom.client()
                .presentContent(IntercomContent.HelpCenterCollections(ids = it.split(",")))
        }
    }

    fun updateUser(userAttributes: UserAttributes) {
        Intercom.client().updateUser(userAttributes)
    }

    fun setUserRegistrationStatus(status: Boolean) {
        viewModelScope.launch {
            prefDataStore.edit { preferences -> preferences[keyUserRegistered] = status }
        }
    }

    private fun showToast(message: String) {
        viewModelScope.launch {
            _effects.emit(MainEffects.ShowToast(message))
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

interface SelfServeActions {
    fun openMessage()
    fun openHelpCenter()
    fun showArticle()
    fun showCarousel()
    fun showSurvey()
    fun showCollections()
}

sealed class MainEffects {
    data class ShowToast(val message: String) : MainEffects()
}
