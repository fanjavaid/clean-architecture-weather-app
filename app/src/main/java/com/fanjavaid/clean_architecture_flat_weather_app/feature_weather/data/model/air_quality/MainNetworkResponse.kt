package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model.air_quality

import com.google.gson.annotations.SerializedName

data class MainNetworkResponse(
    @SerializedName("aqi")
    val aqi: Double // 4.0
)