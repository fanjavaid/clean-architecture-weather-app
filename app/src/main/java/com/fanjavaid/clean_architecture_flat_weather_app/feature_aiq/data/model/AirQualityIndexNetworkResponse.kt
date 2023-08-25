package com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.data.model


import com.google.gson.annotations.SerializedName

data class AirQualityIndexNetworkResponse(
    @SerializedName("data")
    val `data`: DataNetworkResponse?,
    @SerializedName("status")
    val status: String? // ok
)