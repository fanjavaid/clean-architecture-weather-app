package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model.city


import com.google.gson.annotations.SerializedName

data class TpiNetworkResponse(
    @SerializedName("common")
    val common: String, // Papua Niugini
    @SerializedName("official")
    val official: String // Independen Stet bilong Papua Niugini
)