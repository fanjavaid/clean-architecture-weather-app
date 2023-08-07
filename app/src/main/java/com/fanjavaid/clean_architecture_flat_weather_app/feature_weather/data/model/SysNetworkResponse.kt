package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model


import com.google.gson.annotations.SerializedName

data class SysNetworkResponse(
    @SerializedName("country")
    val country: String, // ID
    @SerializedName("id")
    val id: Int, // 2082918
    @SerializedName("sunrise")
    val sunrise: Int, // 1691362954
    @SerializedName("sunset")
    val sunset: Int, // 1691405667
    @SerializedName("type")
    val type: Int // 2
)