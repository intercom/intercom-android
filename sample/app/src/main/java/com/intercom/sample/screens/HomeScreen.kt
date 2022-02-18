package com.intercom.sample.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.intercom.sample.components.InputPanel
import io.intercom.android.sdk.Intercom
import io.intercom.android.sdk.identity.Registration

@ExperimentalComposeUiApi
@Preview(device = Devices.PIXEL_4)
@Composable
fun HomeScreen() {
    InputPanel(
        onRegisterClicked = { uniqueId: String, hasUserId: Boolean ->
            if (hasUserId)
                Intercom.client().registerIdentifiedUser(Registration().withUserId(uniqueId))
            else
                Intercom.client().registerIdentifiedUser(Registration().withEmail(uniqueId))
        },
        onUnregisterClicked = {
            Intercom.client().logout()
        },
        onRegisterUnidentifiedClicked = {
            Intercom.client().registerUnidentifiedUser()
            Intercom.client().setLauncherVisibility(Intercom.VISIBLE)
        })
}