package com.intercom.sample.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun UserUpdate(onUserUpdateClicked: () -> Unit = {}) {
    Column {
        Text(text = "User Details", fontWeight = FontWeight.Bold)
        Button(onClick = { onUserUpdateClicked() }) {
            Text(text = "Update User")
        }
    }
}