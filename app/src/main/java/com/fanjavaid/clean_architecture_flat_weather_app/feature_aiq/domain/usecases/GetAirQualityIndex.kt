package com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.domain.usecases

import com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.domain.model.AirQualityIndex
import com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.domain.repositories.AirQualityRepository
import javax.inject.Inject

class GetAirQualityIndex @Inject constructor(
    private val airQualityRepository: AirQualityRepository
) {

    suspend operator fun invoke(latitude: Double, longitude: Double): AirQualityIndex? {
        return airQualityRepository.getAirQualityIndex(latitude, longitude)
    }
}
