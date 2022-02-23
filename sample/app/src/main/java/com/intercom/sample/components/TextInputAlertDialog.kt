package com.intercom.sample.components

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun SelfServeAlertDialog(
    visibility: MutableState<Boolean> = mutableStateOf(true),
    onSubmit: (String) -> Unit = { _ -> },
    title: MutableState<String> = mutableStateOf("")
) {

    if (visibility.value) {
        val uniqueID = remember { mutableStateOf("") }
        val isConfirmEnabled = remember { mutableStateOf(false) }

        AlertDialog(
            title = {
                Text(text = title.value)
            },
            text = {
                OutlinedTextField(
                    value = uniqueID.value,
                    onValueChange = {
                        uniqueID.value = it
                        isConfirmEnabled.value = it.isNotBlank()
                    },
                    label = { Text(text = "Enter ID") })
            },
            onDismissRequest = {
                visibility.value = false
                uniqueID.value = ""
            },
            dismissButton = {
                Button(
                    onClick = {
                        visibility.value = false
                    }) {
                    Text("Cancel")
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        onSubmit(uniqueID.value)
                        visibility.value = false
                    },
                    enabled = isConfirmEnabled.value,
                ) {
                    Text("Open")
                }
            }
        )
    }
}