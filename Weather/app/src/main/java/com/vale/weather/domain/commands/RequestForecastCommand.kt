package com.vale.weather.domain.commands

import com.vale.weather.data.ForecastRequest
import com.vale.weather.data.ForecastResult
import com.vale.weather.domain.mappers.ForecastDataMapper
import com.vale.weather.domain.model.ForecastList

/**
 * Created by vale on 07/02/2017.
 */
class RequestForecastCommand(val zipCode: String):Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}