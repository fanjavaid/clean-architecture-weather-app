package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model.news

import com.google.gson.annotations.SerializedName

data class GuardianNewsNetworkResponse(
    @SerializedName("response")
    val response: ResponseNetworkResponse
)