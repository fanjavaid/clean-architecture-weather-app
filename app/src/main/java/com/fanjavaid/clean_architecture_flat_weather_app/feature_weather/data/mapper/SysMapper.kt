package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.mapper

import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model.SysNetworkResponse
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.mapper.BaseDomainMapper
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.Sys

class SysMapper : BaseDomainMapper<SysNetworkResponse, Sys> {
    override fun mapToDomainModel(data: SysNetworkResponse): Sys {
        return Sys(
            country = data.country,
            id = data.id,
            sunrise = data.sunrise,
            sunset = data.sunset,
            type = data.type
        )
    }
}
