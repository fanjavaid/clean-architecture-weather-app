package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models

data class City(
    val coord: Coord,
    val country: String, // IT
    val id: Int, // 3163858
    val name: String, // Zocca
    val population: Int, // 4593
    val sunrise: Int, // 1661834187
    val sunset: Int, // 1661882248
    val timezone: Int // 7200
)