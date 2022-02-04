package com.intercom.sample

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel: ViewModel()  {
    var btnState = MutableStateFlow<ViewState>(ViewState(registrationVisibility = true))
}

data class ViewState(
    val registrationVisibility: Boolean
)