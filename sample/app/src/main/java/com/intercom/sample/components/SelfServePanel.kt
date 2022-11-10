package com.intercom.sample.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import com.intercom.sample.SelfServeActions

@Composable
fun SelfServe(
    dialogController: SelfServeAlertDialogController,
    selfServeActions: SelfServeActions
) {
    SelfServeAlertDialog(controller = dialogController)

    Column {
        Text(text = "Other options", fontWeight = FontWeight.Bold)
        FlowRow(
            mainAxisSpacing = 4.dp
        ) {
            Button(onClick = { selfServeActions.openMessage() }) {
                Text(text = "Open Messages")
            }
            Button(onClick = { selfServeActions.openHelpCenter() }) {
                Text(text = "Open Help Center")
            }
            Button(
                onClick = { selfServeActions.showArticle() },
            ) {
                Text(text = "Open Article")
            }
            Button(
                onClick = { selfServeActions.showCarousel() }
            ) {
                Text(text = "Open Carousel")
            }
            Button(
                onClick = { selfServeActions.showSurvey() }
            ) {
                Text(text = "Open Survey")
            }
            Button(
                onClick = { selfServeActions.showCollections() }
            ) {
                Text(text = "Open Help Center Collections")
            }
        }
    }
}

@Preview
@Composable
fun SelfServePreview() {
    SelfServe(
        dialogController = SelfServeAlertDialogController(),
        selfServeActions = object : SelfServeActions {
            override fun openMessage() {
            }

            override fun openHelpCenter() {
            }

            override fun showArticle() {
            }

            override fun showCarousel() {
            }

            override fun showSurvey() {
            }

            override fun showCollections() {
            }
        }
    )
}
