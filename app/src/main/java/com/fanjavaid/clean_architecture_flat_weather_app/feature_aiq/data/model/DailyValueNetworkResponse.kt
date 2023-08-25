package com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.data.model


import com.google.gson.annotations.SerializedName

data class DailyValueNetworkResponse(
    @SerializedName("avg")
    val avg: Int?, // 13
    @SerializedName("day")
    val day: String?, // 2023-08-23
    @SerializedName("max")
    val max: Int?, // 55
    @SerializedName("min")
    val min: Int? // 1
)