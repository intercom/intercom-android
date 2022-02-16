package com.intercom.sample.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun InputPanel(onRegisterClicked: (String) -> Unit = {}) {
    val email = remember { mutableStateOf("")}

    Column {
        Text(text = "Email:")
        TextField(value = email.value, onValueChange = {
            email.value = it
        } )
        Button(onClick = { onRegisterClicked(email.value) }) {
            Text(text = "Register")
        }
    }
}