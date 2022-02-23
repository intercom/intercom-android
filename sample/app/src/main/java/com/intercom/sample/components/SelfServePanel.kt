package com.intercom.sample.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun SelfServe(
    onHelpCenterClicked: () -> Unit = {},
    onArticleClicked: (String) -> Unit = {},
    onCarouselClicked: (String) -> Unit = {}
) {
    val openDialog = remember { mutableStateOf(false) }
    val dialogTitle = remember { mutableStateOf("") }
    SelfServeAlertDialog(visibility = openDialog,
        onSubmit = {
            if (dialogTitle.value == "Open Article")
                onArticleClicked(it)
            else
                onCarouselClicked(it)
        }, title = dialogTitle
    )

    Row(Modifier.padding(end = 4.dp)) {
        Button(onClick = {
            onHelpCenterClicked()
        }) {
            Text(text = "Help Center")
        }
        Button(
            onClick = {
                dialogTitle.value = "Open Article"
                openDialog.value = true
            },
            modifier = Modifier.padding(start = 4.dp, end = 4.dp),
        ) {
            Text(text = "Open Article")
        }
        Button(onClick = {
            dialogTitle.value = "Open Carousel"
            openDialog.value = true
        }) {
            Text(text = "Open Carousel")
        }
    }
}