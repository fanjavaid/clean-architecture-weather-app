package com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.data.model


import com.google.gson.annotations.SerializedName

data class ForecastNetworkResponse(
    @SerializedName("daily")
    val daily: DailyNetworkResponse?
)