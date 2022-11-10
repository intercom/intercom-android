package com.intercom.sample.components

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun SelfServeAlertDialog(
    controller: TextInputAlertDialogController = TextInputAlertDialogController()
) {

    if (controller.visibility.value) {
        val uniqueID = remember { mutableStateOf("") }
        val isConfirmEnabled = remember { mutableStateOf(false) }

        AlertDialog(
            title = {
                Text(text = controller.title.value)
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
                controller.visibility.value = false
                uniqueID.value = ""
            },
            dismissButton = {
                Button(
                    onClick = {
                        controller.visibility.value = false
                    }) {
                    Text("Cancel")
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        controller.onSubmit(uniqueID.value)
                        controller.visibility.value = false
                    },
                    enabled = isConfirmEnabled.value,
                ) {
                    Text("Open")
                }
            }
        )
    }
}

class TextInputAlertDialogController(
    val visibility: MutableState<Boolean> = mutableStateOf(false),
    val title: MutableState<String> = mutableStateOf(""),
    var onSubmit: (String) -> Unit = { _ -> },
) {
    fun show(title: String, onSubmit: (String) -> Unit) {
        this.title.value = title
        this.onSubmit = onSubmit
        visibility.value = true
    }

    fun hide() {
        visibility.value = false
    }

}
