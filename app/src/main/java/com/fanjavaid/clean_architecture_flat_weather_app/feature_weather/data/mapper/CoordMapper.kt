package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.mapper

import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model.CoordNetworkResponse
import com.fanjavaid.clean_architecture_flat_weather_app.shared.mapper.BaseDomainMapper
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.Coord
import javax.inject.Inject

class CoordMapper @Inject constructor() : BaseDomainMapper<CoordNetworkResponse, Coord> {
    override fun mapToDomainModel(data: CoordNetworkResponse): Coord {
        return Coord(
            lat = data.lat,
            lon = data.lon
        )
    }
}
