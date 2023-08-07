package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models

data class Forecast(
    val city: City,
    val cnt: Int, // 96
    val cod: String, // 200
    val list: List<Weather>,
    val message: Int // 0
)