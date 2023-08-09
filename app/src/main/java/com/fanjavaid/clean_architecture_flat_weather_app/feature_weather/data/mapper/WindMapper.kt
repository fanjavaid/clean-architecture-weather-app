package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.mapper

import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model.WindNetworkResponse
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.mapper.BaseDomainMapper
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.Wind

class WindMapper : BaseDomainMapper<WindNetworkResponse, Wind> {
    override fun mapToDomainModel(data: WindNetworkResponse): Wind {
        return Wind(
            deg = data.deg,
            speed = data.speed
        )
    }
}