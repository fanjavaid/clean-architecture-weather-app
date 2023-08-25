package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.repositories

import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.Forecast
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.Weather
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.air_quality.AirQualityIndex

interface WeatherRepository {

    suspend fun getCurrentWeather(latitude: Double, longitude: Double): Weather?

    suspend fun getForecastWeather(latitude: Double, longitude: Double): Forecast?

    suspend fun getAirQualityIndex(latitude: Double, longitude: Double): AirQualityIndex?
}