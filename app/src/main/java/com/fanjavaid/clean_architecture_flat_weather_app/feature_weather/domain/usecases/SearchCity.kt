package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.usecases

import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.city.City
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.repositories.CityRepository
import javax.inject.Inject

class SearchCity @Inject constructor(
    private val cityRepository: CityRepository
) {

    suspend operator fun invoke(keyword: String): List<City> {
        return cityRepository.searchCity(keyword)
    }
}
