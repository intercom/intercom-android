package com.intercom.sample

import android.app.Application
import io.intercom.android.sdk.Intercom

const val API_KEY = ""
const val APP_ID = ""

class SampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Intercom.initialize(this, API_KEY, APP_ID)

    }
}