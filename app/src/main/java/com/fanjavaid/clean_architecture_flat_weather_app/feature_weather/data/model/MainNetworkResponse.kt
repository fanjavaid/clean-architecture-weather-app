package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model


import com.google.gson.annotations.SerializedName

data class MainNetworkResponse(
    @SerializedName("feels_like")
    val feelsLike: Double, // 313.95
    @SerializedName("humidity")
    val humidity: Int, // 64
    @SerializedName("pressure")
    val pressure: Int, // 1008
    @SerializedName("temp")
    val temp: Double, // 306.95
    @SerializedName("temp_max")
    val tempMax: Double, // 308.25
    @SerializedName("temp_min")
    val tempMin: Double // 304.22
)