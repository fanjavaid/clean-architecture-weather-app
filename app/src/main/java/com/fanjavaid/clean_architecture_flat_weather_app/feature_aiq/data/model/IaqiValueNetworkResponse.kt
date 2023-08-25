package com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.data.model

import com.google.gson.annotations.SerializedName

data class IaqiValueNetworkResponse(
    @SerializedName("v")
    val value: Double? // 74.0
)