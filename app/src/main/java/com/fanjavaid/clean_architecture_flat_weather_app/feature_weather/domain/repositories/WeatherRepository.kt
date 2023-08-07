package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.repositories

import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.WeatherData

interface WeatherRepository {

    suspend fun getCurrentWeather(): WeatherData

    suspend fun getForecastWeather(): WeatherData
}