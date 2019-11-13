package com.eightman.codelabs

import android.app.Application

class CodelabsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: CodelabsApplication
            private set
    }
}