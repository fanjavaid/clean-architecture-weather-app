package com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.domain.repositories

import com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.domain.model.AirQualityIndex

interface AirQualityRepository {

    suspend fun getAirQualityIndex(latitude: Double, longitude: Double): AirQualityIndex?
}