package com.intercom.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.intercom.sample.screens.HomeScreen
import com.intercom.sample.screens.UserDetailsScreen
import com.intercom.sample.ui.theme.SampleTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleTheme {
                val navController = rememberNavController()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NavHost(navController = navController, startDestination = "home") {

                        composable("home") {
                            // Not going to work as user_editor doesn't have access 🤔
                            HomeScreen(onUserEditorLaunched = {
                                navController.navigate("user_editor")
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
}
