package com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.data.model

import com.google.gson.annotations.SerializedName

data class MainNetworkResponse(
    @SerializedName("aqi")
    val aqi: Double // 4.0
)