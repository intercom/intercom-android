package com.intercom.sample.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.intercom.sample.components.InputPanel
import io.intercom.android.sdk.Intercom
import io.intercom.android.sdk.identity.Registration

@Preview(device = Devices.NEXUS_10)
@Composable
fun HomeScreen() {
    InputPanel(onRegisterClicked = {
        Intercom.client().registerIdentifiedUser(Registration().withEmail(it))
        Intercom.client().setLauncherVisibility(Intercom.VISIBLE)
    })
}