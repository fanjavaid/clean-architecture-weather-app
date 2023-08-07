package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models

data class WeatherData(
    val base: String, // stations
    val clouds: Clouds,
    val cod: Int, // 200
    val coord: Coord,
    val dt: Int, // 1691391359
    val id: Int, // 1642941
    val main: Main,
    val name: String, // Jagakarsa
    val sys: Sys,
    val timezone: Int, // 25200
    val visibility: Int, // 4000
    val weatherData: List<Weather>,
    val wind: Wind
)