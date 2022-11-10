package com.intercom.sample

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.intercom.sample.screens.HomeScreen
import com.intercom.sample.screens.UserDetailsScreen
import com.intercom.sample.ui.theme.SampleTheme
import io.intercom.android.sdk.Intercom
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

private val Context.dataStore by preferencesDataStore("settings")

class MainActivity : ComponentActivity() {
    private val vm: MainVm by viewModels()
    private val USER_REGISTERED = booleanPreferencesKey("user_registered")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val registrationStatusFlow: Flow<Boolean> = dataStore.data.map { preferences ->
            preferences[USER_REGISTERED] ?: false
        }

        lifecycleScope.launch {
            registrationStatusFlow.collect {
                if (it) {
                    Intercom.client().setLauncherVisibility(Intercom.VISIBLE)
                } else {
                    Intercom.client().setLauncherVisibility(Intercom.GONE)
                }
            }
        }

        setContent {
            SampleTheme {
                val navController = rememberNavController()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NavHost(navController = navController, startDestination = "home") {
                        composable("home") {
                            val rememberCoroutineScope = rememberCoroutineScope()
                            val userRegistrationsStatus =
                                registrationStatusFlow.collectAsState(initial = false)

                            HomeScreen(
                                vm = vm,
                                onUserEditorLaunched = {
                                    navController.navigate("user_editor")
                                },
                                currentRegistrationStatus = userRegistrationsStatus.value,
                                toggleRegistrationStatus = {
                                    rememberCoroutineScope.launch { saveRegistrationStatus(it) }
                                })
                        }
                        composable("user_editor") {
                            UserDetailsScreen(onUserDetailsSaved = {
                                navController.popBackStack()
                            })
                        }
                    }
                }
            }
        }
    }

    suspend fun saveRegistrationStatus(status: Boolean) {
        dataStore.edit { preferences ->
            preferences[USER_REGISTERED] = status
        }
    }
}
