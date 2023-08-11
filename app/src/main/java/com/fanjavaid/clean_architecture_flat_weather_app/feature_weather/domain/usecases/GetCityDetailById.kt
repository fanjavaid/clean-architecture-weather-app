package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.usecases

import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.city.CityDetail
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.repositories.CityRepository
import javax.inject.Inject

class GetCityDetailById @Inject constructor(
    private val cityRepository: CityRepository
) {

    suspend operator fun invoke(cityId: String): CityDetail? {
        return cityRepository.getCityDetailById(cityId)
    }
}
