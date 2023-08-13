package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model.news

import com.google.gson.annotations.SerializedName

data class ResponseNetworkResponse(
    @SerializedName("results")
    val results: List<ResultNetworkResponse>,
    @SerializedName("status")
    val status: String, // ok
)