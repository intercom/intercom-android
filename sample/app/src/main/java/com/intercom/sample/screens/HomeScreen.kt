package com.intercom.sample.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.intercom.sample.components.InputPanel
import com.intercom.sample.components.SelfServe
import com.intercom.sample.components.UserUpdate
import io.intercom.android.sdk.Intercom
import io.intercom.android.sdk.identity.Registration


@Preview(device = Devices.PIXEL_4)
@Composable
fun HomeScreen(onUserEditorLaunched: () -> Unit = {}) {
    val showRegistrationDetails = rememberSaveable { mutableStateOf(false) }
    Column {
        InputPanel(
            onRegisterClicked = { uniqueId: String, hasUserId: Boolean ->
                if (hasUserId)
                    Intercom.client().registerIdentifiedUser(Registration().withUserId(uniqueId))
                else
                    Intercom.client().registerIdentifiedUser(Registration().withEmail(uniqueId))
                Intercom.client().setLauncherVisibility(Intercom.VISIBLE)
                showRegistrationDetails.value = true
            },
            onUnregisterClicked = {
                Intercom.client().logout()
                showRegistrationDetails.value = false
            },
            onRegisterUnidentifiedClicked = {
                Intercom.client().registerUnidentifiedUser()
                Intercom.client().setLauncherVisibility(Intercom.VISIBLE)
                showRegistrationDetails.value = true
            }
        )

        if (showRegistrationDetails.value) {
            UserUpdate(
                onUserUpdateClicked = { onUserEditorLaunched() }
            )
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