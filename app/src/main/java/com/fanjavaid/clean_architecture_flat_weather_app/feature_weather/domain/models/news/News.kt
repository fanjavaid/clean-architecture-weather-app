package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.news

import java.util.Date

data class News(
    val id: String,
    val headline: String,
    val trailText: String,
    val thumbnail: String,
    val lastUpdate: Date?,
    val by: String,
    val body: String
)
