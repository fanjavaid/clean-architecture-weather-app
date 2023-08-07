package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.usecases

import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.Forecast
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.repositories.WeatherRepository
import javax.inject.Inject

class GetForecastWeather @Inject constructor(
    private val repository: WeatherRepository
) {

    suspend operator fun invoke(latitude: Double, longitude: Double): Forecast? {
        return repository.getForecastWeather(latitude, longitude)
    }
}