package com.intercom.sample.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.intercom.sample.MainVm
import com.intercom.sample.components.InputPanel
import com.intercom.sample.components.SelfServe
import com.intercom.sample.components.UserUpdate
import com.intercom.sample.dataStore

@Composable
fun HomeScreen(
    vm: MainVm,
    onUserEditorLaunched: () -> Unit
) {
    Column(modifier = Modifier.padding(16.dp)) {
        InputPanel(
            onRegisterClicked = { uniqueId: String, hasUserId: Boolean ->
                if (hasUserId) {
                    vm.loginIdentifiedUserWithId(id = uniqueId)
                } else {
                    vm.loginIdentifiedUserWithEmail(email = uniqueId)
                }
            },
            onUnregisterClicked = { vm.logout() },
            onRegisterUnidentifiedClicked = { vm.loginUnidentifiedUser() }
        )
        val userRegistrationState = vm.userRegistrationStatus.collectAsState(initial = false)
        if (userRegistrationState.value) {
            UserUpdate(
                onUserUpdateClicked = { onUserEditorLaunched() }
            )
            SelfServe(
                dialogController = vm.dialogController,
                selfServeActions = vm
            )
        }
    }
}

@Preview(device = Devices.PIXEL_4)
@Composable
fun HomeScreenPreview() {
    Surface {
        HomeScreen(
            vm = MainVm(prefDataStore = LocalContext.current.dataStore),
            onUserEditorLaunched = {}
        )
    }
}
