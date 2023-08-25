package com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.domain.model

data class AirQualityIndex(
    val index: Int = 0,
    val info: String? = null,
    val description: String? = null,
    val dominantPollution: AirQualityDominantPollution? = null,
    val forecast: List<AirQualityForecast> = listOf(),
    val metadata: AirQualityMetadata? = null
)
