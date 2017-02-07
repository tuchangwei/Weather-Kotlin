package com.vale.weather.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.vale.weather.R
import com.vale.weather.data.ForecastRequest
import com.vale.weather.domain.commands.RequestForecastCommand
import com.vale.weather.ui.adapters.ForecastListAdapter
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity(), AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val forecastList: RecyclerView = find(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)

        doAsync {
            val result = RequestForecastCommand("94043").execute()
            info {result}
            uiThread {
                forecastList.adapter = ForecastListAdapter(result)
            }
        }
    }
}
