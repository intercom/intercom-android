package com.intercom.sample

import androidx.lifecycle.ViewModel
import com.intercom.sample.components.TextInputAlertDialogController
import io.intercom.android.sdk.Intercom
import io.intercom.android.sdk.IntercomContent
import io.intercom.android.sdk.IntercomSpace

class MainVm : ViewModel() {
    val dialogController = TextInputAlertDialogController()

    fun openMessage() = Intercom.client().present(IntercomSpace.Messages)
    fun openHelpCenter() = Intercom.client().present(IntercomSpace.HelpCenter)
    fun showArticle() {
        dialogController.show("Article id") {
            Intercom.client().presentContent(IntercomContent.Article(id = it))
        }
    }

    fun showCarousel() {
        dialogController.show("Carousel id") {
            Intercom.client().presentContent(IntercomContent.Carousel(id = it))
        }
    }

    fun showSurvey() {
        dialogController.show("Survey id") {
            Intercom.client().presentContent(IntercomContent.Survey(id = it))
        }
    }

    fun showCollections() {
        dialogController.show("Collection ids") {
            Intercom.client()
                .presentContent(IntercomContent.HelpCenterCollections(ids = it.split(",")))
        }
    }
}
