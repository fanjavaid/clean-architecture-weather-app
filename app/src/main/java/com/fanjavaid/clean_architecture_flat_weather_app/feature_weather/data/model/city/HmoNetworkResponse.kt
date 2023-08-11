package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model.city


import com.google.gson.annotations.SerializedName

data class HmoNetworkResponse(
    @SerializedName("common")
    val common: String, // Papua Niu Gini
    @SerializedName("official")
    val official: String // Independen Stet bilong Papua Niugini
)