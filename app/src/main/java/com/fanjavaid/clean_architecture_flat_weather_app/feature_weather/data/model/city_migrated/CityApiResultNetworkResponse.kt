package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model.city_migrated

import com.google.gson.annotations.SerializedName

data class CityApiResultNetworkResponse(
    @SerializedName("count")
    val count: Int, // 25
    @SerializedName("_embedded")
    val embedded: EmbeddedNetworkResponse
)