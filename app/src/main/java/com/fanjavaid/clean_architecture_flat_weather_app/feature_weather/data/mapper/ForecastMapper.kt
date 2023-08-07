package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.mapper

import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model.ForecastNetworkResponse
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.mapper.BaseDomainMapper
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.Forecast

class ForecastMapper : BaseDomainMapper<ForecastNetworkResponse, Forecast> {
    override fun mapToDomainModel(data: ForecastNetworkResponse): Forecast {
        return Forecast(
            city = CityMapper().mapToDomainModel(data.city),
            cnt = data.cnt,
            cod = data.cod,
            list = data.list.map(WeatherMapper()::mapToDomainModel),
            message = data.message
        )
    }
}
