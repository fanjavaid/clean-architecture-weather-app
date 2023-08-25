package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.usecases

import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.air_quality.AirQualityIndex
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.repositories.WeatherRepository
import javax.inject.Inject

class GetAirQualityIndex @Inject constructor(
    private val weatherRepository: WeatherRepository
) {

    suspend operator fun invoke(latitude: Double, longitude: Double): AirQualityIndex? {
        return weatherRepository.getAirQualityIndex(latitude, longitude)
    }
}
