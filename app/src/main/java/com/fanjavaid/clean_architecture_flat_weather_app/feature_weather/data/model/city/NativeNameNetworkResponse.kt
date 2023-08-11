package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model.city


import com.google.gson.annotations.SerializedName

data class NativeNameNetworkResponse(
    @SerializedName("eng")
    val eng: EngNetworkResponse,
    @SerializedName("hmo")
    val hmo: HmoNetworkResponse,
    @SerializedName("tpi")
    val tpi: TpiNetworkResponse
)