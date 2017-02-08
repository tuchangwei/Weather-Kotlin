package com.vale.weather.ui

import android.app.Application
import com.vale.weather.ui.utils.DelegatesExt
import kotlin.reflect.KProperty

class App: Application() {
    companion object {
        var instance: App by DelegatesExt.notNullSingleVauleVaule()
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}

