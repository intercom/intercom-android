package com.intercom.sample

import android.app.Application
import io.intercom.android.sdk.Intercom

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // FIXME: Causes IllegalAccessException: Tried to access the API:LayoutInflater which needs to have proper configuration from a non-UI Context
        Intercom.initialize(this, "", "")
    }
}
