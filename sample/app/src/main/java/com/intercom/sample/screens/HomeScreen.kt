package com.intercom.sample.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.intercom.sample.components.InputPanel
import com.intercom.sample.components.SelfServe
import io.intercom.android.sdk.Intercom
import io.intercom.android.sdk.identity.Registration


@Preview(device = Devices.PIXEL_4)
@Composable
fun HomeScreen() {
    val showSelfServe = rememberSaveable { mutableStateOf(false) }
    Column {
        InputPanel(
            onRegisterClicked = { uniqueId: String, hasUserId: Boolean ->
                if (hasUserId)
                    Intercom.client().registerIdentifiedUser(Registration().withUserId(uniqueId))
                else
                    Intercom.client().registerIdentifiedUser(Registration().withEmail(uniqueId))
                showSelfServe.value = true
            },
            onUnregisterClicked = {
                Intercom.client().logout()
                showSelfServe.value = false
            },
            onRegisterUnidentifiedClicked = {
                Intercom.client().registerUnidentifiedUser()
                Intercom.client().setLauncherVisibility(Intercom.VISIBLE)
                showSelfServe.value = true
            })

        if (showSelfServe.value) {
            SelfServe(
                onHelpCenterClicked = {
                    Intercom.client().displayHelpCenter()
                },
                onArticleClicked = {
                    Intercom.client().displayArticle(it)
                },
                onCarouselClicked = {
                    Intercom.client().displayCarousel(it)
                }
            )
        }
    }
}