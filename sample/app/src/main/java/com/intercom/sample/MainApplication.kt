package com.intercom.sample

import android.app.Application
import io.intercom.android.sdk.Intercom

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Intercom.initialize(this, "", "")
    }
}