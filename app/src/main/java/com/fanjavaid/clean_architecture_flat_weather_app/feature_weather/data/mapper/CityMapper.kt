package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.mapper

import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model.CityNetworkResponse
import com.fanjavaid.clean_architecture_flat_weather_app.core.mapper.BaseDomainMapper
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.City
import javax.inject.Inject

class CityMapper @Inject constructor(
    private val coordMapper: CoordMapper
) : BaseDomainMapper<CityNetworkResponse, City> {
    override fun mapToDomainModel(data: CityNetworkResponse): City {
        return City(
            coord = coordMapper.mapToDomainModel(data.coord),
            country = data.country,
            id = data.id,
            name = data.name,
            population = data.population,
            sunrise = data.sunrise,
            sunset = data.sunset,
            timezone = data.timezone
        )
    }
}
