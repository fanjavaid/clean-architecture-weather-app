package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.usecases

import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.WeatherData
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.repositories.WeatherRepository

class GetCurrentWeather(
    private val repository: WeatherRepository
) {

    suspend operator fun invoke(): WeatherData {
        return repository.getCurrentWeather()
    }
}
