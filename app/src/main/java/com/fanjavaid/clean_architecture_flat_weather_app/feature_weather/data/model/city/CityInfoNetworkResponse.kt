package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model.city


import com.google.gson.annotations.SerializedName

data class CityInfoNetworkResponse(
    @SerializedName("name")
    val name: NameNetworkResponse
)