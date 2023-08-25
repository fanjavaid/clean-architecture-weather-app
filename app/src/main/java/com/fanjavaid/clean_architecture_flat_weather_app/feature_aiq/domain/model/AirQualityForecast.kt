package com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.domain.model

data class AirQualityForecast(
    val type: String? = null,
    val values: List<AirQualityForecastValue> = listOf()
)

