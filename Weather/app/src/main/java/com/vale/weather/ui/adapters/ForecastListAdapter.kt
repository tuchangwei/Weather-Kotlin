package com.vale.weather.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.vale.weather.domain.model.ForecastList

/**
 * Created by vale on 05/02/2017.
 */
class ForecastListAdapter(val weekForecast: ForecastList): RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(weekForecast[position]) {
            holder.textView.text = "$date - $description - $high/$low"
        }
    }

    override fun getItemCount(): Int = weekForecast.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    class ViewHolder(val textView: TextView): RecyclerView.ViewHolder(textView)


}