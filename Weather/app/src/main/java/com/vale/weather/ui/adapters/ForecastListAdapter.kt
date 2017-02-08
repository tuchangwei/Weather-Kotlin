package com.vale.weather.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.vale.weather.R
import com.vale.weather.domain.model.Forecast
import com.vale.weather.domain.model.ForecastList
import com.vale.weather.ui.utils.ctx
import org.jetbrains.anko.find
import org.w3c.dom.Text

interface OnItemClickListener {
    operator fun invoke(forecast: Forecast)
}
class ForecastListAdapter(val weekForecast: ForecastList,
                          val itemClick:(Forecast)-> Unit): RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    override fun getItemCount(): Int = weekForecast.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast,parent,false)
        return ViewHolder(view, itemClick)
    }

    class ViewHolder(val view: View, val itemClick: (Forecast)->Unit): RecyclerView.ViewHolder(view) {
        private val iconView = view.find<ImageView>(R.id.icon)
        private val dateView = view.find<TextView>(R.id.date)
        private val descriptionView = view.find<TextView>(R.id.descrpition)
        private val maxTemperatureView = view.find<TextView>(R.id.maxTemperature)
        private val minTemperatureView = view.find<TextView>(R.id.minTemperature)

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTemperatureView.text = "${high}º"
                minTemperatureView.text = "${low}º"
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}