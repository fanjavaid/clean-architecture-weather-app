package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model.city_migrated

import com.google.gson.annotations.SerializedName

data class LinksNetworkResponse(
    @SerializedName("city:item")
    val cityItem: CityItemNetworkResponse
)