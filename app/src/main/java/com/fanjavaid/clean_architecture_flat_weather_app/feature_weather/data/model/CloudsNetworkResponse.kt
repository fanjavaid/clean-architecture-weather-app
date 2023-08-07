package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model


import com.google.gson.annotations.SerializedName

data class CloudsNetworkResponse(
    @SerializedName("all")
    val all: Int // 40
)