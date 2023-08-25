package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.mapper

import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model.WindNetworkResponse
import com.fanjavaid.clean_architecture_flat_weather_app.shared.mapper.BaseDomainMapper
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.Wind
import javax.inject.Inject

class WindMapper @Inject constructor() : BaseDomainMapper<WindNetworkResponse, Wind> {
    override fun mapToDomainModel(data: WindNetworkResponse): Wind {
        return Wind(
            deg = data.deg,
            speed = data.speed
        )
    }
}
