package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model


import com.google.gson.annotations.SerializedName

data class WindNetworkResponse(
    @SerializedName("deg")
    val deg: Int, // 70
    @SerializedName("speed")
    val speed: Double // 2.57
)