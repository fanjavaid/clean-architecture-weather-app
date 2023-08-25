package com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.data.source

import com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.data.model.AirQualityIndexNetworkResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface AirQualityService {

    @GET("/feed/geo:{lat};{lon}")
    suspend fun getAirQualityIndex(
        @Path("lat") lat: Double,
        @Path("lon") lon: Double
    ): AirQualityIndexNetworkResponse
}
