package com.vale.weather.data

import android.util.Log
import java.net.URL

/**
 * Created by vale on 06/02/2017.
 */
class Request(val url:String) {
    fun run() {
        val forecastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName, forecastJsonStr)
    }
}