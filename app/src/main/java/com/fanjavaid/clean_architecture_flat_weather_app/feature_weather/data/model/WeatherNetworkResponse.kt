package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model

import com.google.gson.annotations.SerializedName

data class WeatherNetworkResponse(
    @SerializedName("base")
    val base: String, // stations
    @SerializedName("clouds")
    val clouds: CloudsNetworkResponse,
    @SerializedName("cod")
    val cod: Int, // 200
    @SerializedName("coord")
    val coord: CoordNetworkResponse,
    @SerializedName("dt")
    val dt: Int, // 1691391359
    @SerializedName("id")
    val id: Int, // 1642941
    @SerializedName("main")
    val main: MainNetworkResponse,
    @SerializedName("name")
    val name: String, // Jagakarsa
    @SerializedName("sys")
    val sys: SysNetworkResponse,
    @SerializedName("timezone")
    val timezone: Int, // 25200
    @SerializedName("visibility")
    val visibility: Int, // 4000
    @SerializedName("weather")
    val weatherData: List<WeatherDataNetworkResponse>,
    @SerializedName("wind")
    val wind: WindNetworkResponse
)