package com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.data.source

import com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.data.model.AirPollutionNetworkResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface AirQualityService {

    @GET("air_pollution")
    suspend fun getAirQualityIndex(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
    ): AirPollutionNetworkResponse
}
