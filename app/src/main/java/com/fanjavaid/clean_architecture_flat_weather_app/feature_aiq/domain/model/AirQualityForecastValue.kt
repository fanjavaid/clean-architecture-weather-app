package com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.domain.model

import java.util.Date

data class AirQualityForecastValue(
    val min: Int = 0,
    val max: Int = 0,
    val average: Int = 0,
    val date: Date = Date()
)