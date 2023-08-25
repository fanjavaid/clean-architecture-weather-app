package com.fanjavaid.clean_architecture_flat_weather_app.shared.domain

import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.city.CityDetail
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.repositories.CityRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLastSavedCity @Inject constructor(
    private val cityRepository: CityRepository
) {

    suspend operator fun invoke(): Flow<CityDetail> {
        return cityRepository.getLastSavedCity()
    }
}
