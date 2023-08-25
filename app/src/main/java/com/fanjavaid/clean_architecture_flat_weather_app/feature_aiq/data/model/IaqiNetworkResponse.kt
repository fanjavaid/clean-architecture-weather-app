package com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.data.model

import com.google.gson.annotations.SerializedName

data class IaqiNetworkResponse(
    @SerializedName("o3")
    val o3: IaqiValueNetworkResponse?,
    @SerializedName("pm10")
    val pm10: IaqiValueNetworkResponse?,
    @SerializedName("pm25")
    val pm25: IaqiValueNetworkResponse?,
    @SerializedName("no2")
    val no2: IaqiValueNetworkResponse?,
    @SerializedName("so2")
    val so2: IaqiValueNetworkResponse?,
    @SerializedName("co")
    val co: IaqiValueNetworkResponse?
)
