package com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.data.model

import com.google.gson.annotations.SerializedName

data class ComponentsNetworkResponse(
    @SerializedName("co")
    val co: Double, // 203.609
    @SerializedName("nh3")
    val nh3: Double, // 0.117
    @SerializedName("no")
    val no: Double, // 0.0
    @SerializedName("no2")
    val no2: Double, // 0.396
    @SerializedName("o3")
    val o3: Double, // 75.102
    @SerializedName("pm10")
    val pm10: Double, // 92.214
    @SerializedName("pm2_5")
    val pm25: Double, // 23.253
    @SerializedName("so2")
    val so2: Double // 0.648
)