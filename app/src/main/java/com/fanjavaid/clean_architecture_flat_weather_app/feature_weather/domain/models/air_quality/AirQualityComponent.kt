package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.air_quality

data class AirQualityComponent(
    val name: String,
    val desc: String,
    val value: Double = 0.0
)