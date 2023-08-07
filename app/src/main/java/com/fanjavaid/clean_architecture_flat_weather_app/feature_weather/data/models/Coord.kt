package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.models


import com.google.gson.annotations.SerializedName

data class Coord(
    @SerializedName("lat")
    val lat: Double, // -6.3065
    @SerializedName("lon")
    val lon: Double // 106.8402
)