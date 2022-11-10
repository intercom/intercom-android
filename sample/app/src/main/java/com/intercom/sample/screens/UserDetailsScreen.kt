package com.intercom.sample.screens

import androidx.compose.runtime.Composable
import com.intercom.sample.components.UserDetailsEditor
import io.intercom.android.sdk.UserAttributes

@Composable
fun UserDetailsScreen(onUserDetailsSaved: (UserAttributes) -> Unit = {}) {
    UserDetailsEditor(onUserDetailsSaved = {
        onUserDetailsSaved(it)
    })
}
