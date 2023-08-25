package com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.data.model


import com.google.gson.annotations.SerializedName

data class CityNetworkResponse(
    @SerializedName("url")
    val url: String? // https://aqicn.org/city/indonesia/jakarta/us-consulate/south
)