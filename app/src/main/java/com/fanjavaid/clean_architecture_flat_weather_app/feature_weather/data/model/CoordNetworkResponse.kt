package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model


import com.google.gson.annotations.SerializedName

data class CoordNetworkResponse(
    @SerializedName("lat")
    val lat: Double, // -6.3065
    @SerializedName("lon")
    val lon: Double // 106.8402
)