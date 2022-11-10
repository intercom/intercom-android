package com.intercom.sample.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun InputPanel(
    onRegisterClicked: (String, Boolean) -> Unit = { _, _ -> },
    onRegisterUnidentifiedClicked: () -> Unit = {},
    onUnregisterClicked: () -> Unit = {}
) {
    val email = rememberSaveable { mutableStateOf("") }
    val userId = rememberSaveable { mutableStateOf("") }
    val focusManager = LocalFocusManager.current

    Column {
        OutlinedTextField(
            value = email.value,
            onValueChange = { email.value = it },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email
            )
        )
        OutlinedTextField(
            value = userId.value,
            onValueChange = { userId.value = it },
            label = { Text("User ID") }
        )
        Row {
            Button(
                modifier = Modifier.padding(end = 4.dp),
                onClick = {
                    when {
                        userId.value.isNotBlank() -> onRegisterClicked(userId.value, true)
                        email.value.isNotBlank() -> onRegisterClicked(email.value, false)
                        else -> onRegisterUnidentifiedClicked()
                    }
                    focusManager.clearFocus()
                },
            ) {
                Text(text = "Register")
            }
            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Magenta,
                    contentColor = Color.White
                ),
                onClick = {
                    onUnregisterClicked()
                    userId.value = ""
                    email.value = ""
                    focusManager.clearFocus()
                }) {
                Text(text = "Unregister")
            }
        }
    }
}
