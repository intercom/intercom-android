package com.intercom.sample.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.intercom.sample.MainVm
import com.intercom.sample.components.InputPanel
import com.intercom.sample.components.SelfServe
import com.intercom.sample.components.UserUpdate
import io.intercom.android.sdk.Intercom
import io.intercom.android.sdk.IntercomError
import io.intercom.android.sdk.IntercomStatusCallback
import io.intercom.android.sdk.identity.Registration


@Composable
fun HomeScreen(
    vm: MainVm,
    onUserEditorLaunched: () -> Unit = {},
    currentRegistrationStatus: Boolean = false,
    toggleRegistrationStatus: (Boolean) -> Unit = {}
) {
    Column {
        InputPanel(
            onRegisterClicked = { uniqueId: String, hasUserId: Boolean ->
                if (hasUserId)
                    Intercom.client()
                        .loginIdentifiedUser(userRegistration = Registration().withUserId(uniqueId))
                else
                    Intercom.client()
                        .loginIdentifiedUser(userRegistration = Registration().withEmail(uniqueId))
                toggleRegistrationStatus.invoke(true)
            },
            onUnregisterClicked = {
                Intercom.client().logout()
                toggleRegistrationStatus(false)
            },
            onRegisterUnidentifiedClicked = {
                Intercom.client().loginUnidentifiedUser(
                    intercomStatusCallback = object : IntercomStatusCallback {
                        override fun onFailure(intercomError: IntercomError) {
                            // Handle failure
                        }

                        override fun onSuccess() {
                            // Handle success
                            Intercom.client().setLauncherVisibility(Intercom.VISIBLE)
                        }
                    }
                )
                toggleRegistrationStatus(true)
            }
        )

        if (currentRegistrationStatus) {
            UserUpdate(
                onUserUpdateClicked = { onUserEditorLaunched() }
            )
            SelfServe(vm)
        }
    }
}

@Preview(device = Devices.PIXEL_4)
@Composable
fun HomeScreenPreview() {
    HomeScreen(vm = MainVm())
}
