package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.source

import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model.ForecastNetworkResponse
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model.WeatherNetworkResponse
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model.air_quality.AirPollutionNetworkResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherNetworkService {

    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
    ): WeatherNetworkResponse

    @GET("forecast")
    suspend fun getForecastWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
    ): ForecastNetworkResponse

    @GET("air_pollution")
    suspend fun getAirQualityIndex(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
    ): AirPollutionNetworkResponse
}