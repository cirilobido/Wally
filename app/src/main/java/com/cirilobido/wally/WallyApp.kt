package com.cirilobido.wally

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class WallyApp: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}