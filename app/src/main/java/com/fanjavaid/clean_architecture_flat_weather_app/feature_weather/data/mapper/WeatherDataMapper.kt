package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.mapper

import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model.WeatherDataNetworkResponse
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.mapper.BaseDomainMapper
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.WeatherData

class WeatherDataMapper : BaseDomainMapper<WeatherDataNetworkResponse, WeatherData> {
    override fun mapToDomainModel(data: WeatherDataNetworkResponse): WeatherData {
        return WeatherData(
            description = data.description,
            icon = data.icon,
            id = data.id,
            main = data.main
        )
    }
}
