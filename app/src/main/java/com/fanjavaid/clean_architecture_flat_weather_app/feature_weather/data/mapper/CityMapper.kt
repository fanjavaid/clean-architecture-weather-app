package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.mapper

import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model.CityNetworkResponse
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.mapper.BaseDomainMapper
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.City

class CityMapper : BaseDomainMapper<CityNetworkResponse, City> {
    override fun mapToDomainModel(data: CityNetworkResponse): City {
        return City(
            coord = CoordMapper().mapToDomainModel(data.coord),
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
