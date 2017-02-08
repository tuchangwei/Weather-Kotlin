package com.vale.weather.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.vale.weather.R
import com.vale.weather.data.ForecastRequest
import com.vale.weather.domain.commands.RequestForecastCommand
import com.vale.weather.domain.model.Forecast
import com.vale.weather.ui.adapters.ForecastListAdapter
import com.vale.weather.ui.adapters.OnItemClickListener
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity(), AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        forecastList.layoutManager = LinearLayoutManager(this)

        doAsync {
            val result = RequestForecastCommand("94043").execute()
            uiThread {
                forecastList.adapter = ForecastListAdapter(result) { forecast ->
                       toast(forecast.date)
                }
            }
        }
    }
}
