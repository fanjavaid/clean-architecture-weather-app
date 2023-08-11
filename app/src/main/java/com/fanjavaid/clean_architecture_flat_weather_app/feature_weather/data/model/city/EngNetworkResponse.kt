package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model.city


import com.google.gson.annotations.SerializedName

data class EngNetworkResponse(
    @SerializedName("common")
    val common: String, // Papua New Guinea
    @SerializedName("official")
    val official: String // Independent State of Papua New Guinea
)