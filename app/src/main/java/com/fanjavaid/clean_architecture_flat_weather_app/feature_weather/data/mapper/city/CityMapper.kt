package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.mapper.city

import com.fanjavaid.clean_architecture_flat_weather_app.shared.mapper.BaseDomainMapper
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model.city_migrated.EmbeddedNetworkResponse
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.city.City
import javax.inject.Inject

class CityMapper @Inject constructor() : BaseDomainMapper<EmbeddedNetworkResponse, List<City>> {
    override fun mapToDomainModel(data: EmbeddedNetworkResponse): List<City> {
        return data.citySearchResults.map {
            City(
                geoId = it.links.cityItem.href.substringAfterLast("cities/").replace("/", ""),
                cityName = it.matchingFullName,
            )
        }
    }
}
