package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model.air_quality

import com.google.gson.annotations.SerializedName

data class AirPollutionDataNetworkResponse(
    @SerializedName("components")
    val components: ComponentsNetworkResponse,
    @SerializedName("dt")
    val dt: Int, // 1606147200
    @SerializedName("main")
    val main: MainNetworkResponse
)