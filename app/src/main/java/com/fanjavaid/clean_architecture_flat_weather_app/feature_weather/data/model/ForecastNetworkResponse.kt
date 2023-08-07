package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model

import com.google.gson.annotations.SerializedName

data class ForecastNetworkResponse(
    @SerializedName("city")
    val city: CityNetworkResponse,
    @SerializedName("cnt")
    val cnt: Int, // 96
    @SerializedName("cod")
    val cod: String, // 200
    @SerializedName("list")
    val list: List<WeatherNetworkResponse>,
    @SerializedName("message")
    val message: Int // 0
)