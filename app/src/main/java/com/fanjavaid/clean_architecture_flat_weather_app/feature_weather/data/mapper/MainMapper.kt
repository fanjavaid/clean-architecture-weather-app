package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.mapper

import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model.MainNetworkResponse
import com.fanjavaid.clean_architecture_flat_weather_app.shared.mapper.BaseDomainMapper
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.Main
import javax.inject.Inject

class MainMapper @Inject constructor() : BaseDomainMapper<MainNetworkResponse, Main> {
    override fun mapToDomainModel(data: MainNetworkResponse): Main {
        return Main(
            feelsLike = data.feelsLike,
            humidity = data.humidity,
            pressure = data.pressure,
            temp = data.temp,
            tempMax = data.tempMax,
            tempMin = data.tempMin
        )
    }
}
