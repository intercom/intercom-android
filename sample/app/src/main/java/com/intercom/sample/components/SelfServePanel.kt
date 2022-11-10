package com.intercom.sample.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import com.intercom.sample.MainVm

@Composable
fun SelfServe(vm: MainVm) {
    SelfServeAlertDialog(controller = vm.dialogController)

    Column {
        Text(text = "Other options", fontWeight = FontWeight.Bold)
        FlowRow(
            mainAxisSpacing = 4.dp
        ) {
            Button(onClick = { vm.openMessage() }) {
                Text(text = "Open Messages")
            }
            Button(onClick = { vm.openHelpCenter() }) {
                Text(text = "Open Help Center")
            }
            Button(
                onClick = { vm.showArticle() },
            ) {
                Text(text = "Open Article")
            }
            Button(
                onClick = { vm.showCarousel() }
            ) {
                Text(text = "Open Carousel")
            }
            Button(
                onClick = { vm.showSurvey() }
            ) {
                Text(text = "Open Survey")
            }
            Button(
                onClick = { vm.showCollections() }
            ) {
                Text(text = "Open Help Center Collections")
            }
        }
    }
}

@Preview
@Composable
fun SelfServePreview() {
    SelfServe(vm = MainVm())
}
