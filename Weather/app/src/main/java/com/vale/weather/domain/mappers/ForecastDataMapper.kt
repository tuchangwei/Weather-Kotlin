package com.vale.weather.domain.mappers

import com.vale.weather.data.ForecastResult
import com.vale.weather.data.Forecast
import com.vale.weather.domain.model.ForecastList
import java.text.DateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import com.vale.weather.domain.model.Forecast as ModelForecast
class ForecastDataMapper {
    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(forecast.city.name, forecast.city.country,
                convertForecastListToDomin(forecast.list))
    }

    private fun convertForecastListToDomin(list: List<Forecast>): List<ModelForecast> {
        return list.mapIndexed { i, forecast ->
            val dt = Calendar.getInstance().timeInMillis
            + TimeUnit.DAYS.toMillis(i.toLong())
            convertForecastIntemToDomain(forecast.copy(dt=dt))
        }
    }

    private fun convertForecastIntemToDomain(forecast: Forecast): ModelForecast {
       return ModelForecast(convertDate(forecast.dt),
               forecast.weather[0].description,
               forecast.temp.max.toInt(),
               forecast.temp.min.toInt())
    }

    private fun convertDate(date: Long): String {
        val dt = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return dt.format(date)
    }
}