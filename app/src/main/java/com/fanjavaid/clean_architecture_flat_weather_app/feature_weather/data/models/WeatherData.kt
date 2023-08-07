package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.models


import com.google.gson.annotations.SerializedName

data class WeatherData(
    @SerializedName("description")
    val description: String, // haze
    @SerializedName("icon")
    val icon: String, // 50d
    @SerializedName("id")
    val id: Int, // 721
    @SerializedName("main")
    val main: String // Haze
)