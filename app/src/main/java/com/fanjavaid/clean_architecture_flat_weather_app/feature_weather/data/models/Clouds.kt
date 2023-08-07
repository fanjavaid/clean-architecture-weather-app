package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.models


import com.google.gson.annotations.SerializedName

data class Clouds(
    @SerializedName("all")
    val all: Int // 40
)