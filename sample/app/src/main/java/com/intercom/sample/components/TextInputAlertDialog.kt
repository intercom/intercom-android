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
    controller: SelfServeAlertDialogController = SelfServeAlertDialogController()
) {
    if (controller.visibility.value) {
        val isConfirmEnabled = remember { mutableStateOf(false) }

        AlertDialog(
            text = {
                OutlinedTextField(
                    value = controller.text.value,
                    onValueChange = {
                        controller.text.value = it
                        isConfirmEnabled.value = it.isNotBlank()
                    },
                    label = { Text(text = controller.label.value) }
                )
            },
            onDismissRequest = { controller.hide() },
            dismissButton = {
                Button(
                    onClick = { controller.hide() }) {
                    Text("Cancel")
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        controller.submit()
                        controller.hide()
                    },
                    enabled = isConfirmEnabled.value,
                ) {
                    Text("Open")
                }
            }
        )
    }
}

class SelfServeAlertDialogController(
    val visibility: MutableState<Boolean> = mutableStateOf(false),
    val label: MutableState<String> = mutableStateOf(""),
    var onSubmit: (String) -> Unit = { _ -> },
) {
    val text = mutableStateOf("")

    fun show(label: String, onSubmit: (String) -> Unit) {
        this.label.value = label
        this.onSubmit = onSubmit
        visibility.value = true
    }

    fun hide() {
        text.value = ""
        label.value = ""
        onSubmit = { _ -> }
        visibility.value = false
    }

    fun submit() {
        onSubmit(text.value)
    }
}
