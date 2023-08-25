package com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.data.model


import com.google.gson.annotations.SerializedName

data class DailyNetworkResponse(
    @SerializedName("o3")
    val o3: List<DailyValueNetworkResponse?>?,
    @SerializedName("pm10")
    val pm10: List<DailyValueNetworkResponse?>?,
    @SerializedName("pm25")
    val pm25: List<DailyValueNetworkResponse?>?
)