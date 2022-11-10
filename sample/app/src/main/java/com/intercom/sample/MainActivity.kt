package com.intercom.sample

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.datastore.preferences.preferencesDataStore
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.intercom.sample.screens.HomeScreen
import com.intercom.sample.screens.UserDetailsScreen
import com.intercom.sample.ui.theme.SampleTheme

private val Context.dataStore by preferencesDataStore("settings")

class MainActivity : ComponentActivity() {
    private val vm: MainVm by viewModels(factoryProducer = { MainVm.getVmFactory(dataStore) })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleTheme {
                val navController = rememberNavController()
                Scaffold {
                    NavHost(
                        modifier = Modifier.padding(it),
                        navController = navController,
                        startDestination = "home"
                    ) {
                        composable("home") {
                            HomeScreen(
                                vm = vm,
                                onUserEditorLaunched = {
                                    navController.navigate("user_editor")
                                },
                            )
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
}
