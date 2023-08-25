package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.air_quality

data class AirQualityIndex(
    val qualityIndex: Double = 0.0,
    val dateTime: Long = System.currentTimeMillis(),
    val components: List<AirQualityComponent> = listOf()
)
