package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.models


import com.google.gson.annotations.SerializedName

data class WeatherResponseData(
    @SerializedName("base")
    val base: String, // stations
    @SerializedName("clouds")
    val clouds: Clouds,
    @SerializedName("cod")
    val cod: Int, // 200
    @SerializedName("coord")
    val coord: Coord,
    @SerializedName("dt")
    val dt: Int, // 1691391359
    @SerializedName("id")
    val id: Int, // 1642941
    @SerializedName("main")
    val main: Main,
    @SerializedName("name")
    val name: String, // Jagakarsa
    @SerializedName("sys")
    val sys: Sys,
    @SerializedName("timezone")
    val timezone: Int, // 25200
    @SerializedName("visibility")
    val visibility: Int, // 4000
    @SerializedName("weather")
    val weatherData: List<WeatherData>,
    @SerializedName("wind")
    val wind: Wind
)