package com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.data.model


import com.google.gson.annotations.SerializedName

data class DataNetworkResponse(
    @SerializedName("aqi")
    val aqi: Int?, // 74
    @SerializedName("attributions")
    val attributions: List<AttributionNetworkResponse>?,
    @SerializedName("city")
    val city: CityNetworkResponse?,
    @SerializedName("dominentpol")
    val dominentPol: String?, // pm10
    @SerializedName("forecast")
    val forecast: ForecastNetworkResponse?,
    @SerializedName("iaqi")
    val iaqi: IaqiNetworkResponse?,
    @SerializedName("idx")
    val idx: Int?, // 8648
    @SerializedName("time")
    val time: TimeNetworkResponse?
)
