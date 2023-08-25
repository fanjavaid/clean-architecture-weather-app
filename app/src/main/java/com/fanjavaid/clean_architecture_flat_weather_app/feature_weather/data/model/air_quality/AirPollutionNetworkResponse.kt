package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model.air_quality

import com.google.gson.annotations.SerializedName

data class AirPollutionNetworkResponse(
//    @SerializedName("coord")
//    val coord: List<Double>,
    @SerializedName("list")
    val list: List<AirPollutionDataNetworkResponse>
)