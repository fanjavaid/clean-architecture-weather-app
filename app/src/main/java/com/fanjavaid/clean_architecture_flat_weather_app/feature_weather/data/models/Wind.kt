package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.models


import com.google.gson.annotations.SerializedName

data class Wind(
    @SerializedName("deg")
    val deg: Int, // 70
    @SerializedName("speed")
    val speed: Double // 2.57
)