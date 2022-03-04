package com.intercom.sample.screens

import androidx.compose.runtime.Composable
import com.intercom.sample.components.UserDetailsEditor
import io.intercom.android.sdk.Intercom

@Composable
fun UserDetailsScreen(onUserDetailsSaved: () -> Unit = {}) {
    UserDetailsEditor(onUserDetailsSaved = {
        Intercom.client().updateUser(it)
        onUserDetailsSaved()
    })
}