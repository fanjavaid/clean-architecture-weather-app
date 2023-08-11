package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model.city_migrated

import com.google.gson.annotations.SerializedName

data class CityItemNetworkResponse(
    @SerializedName("href")
    val href: String // https://api.teleport.org/api/cities/geonameid:5391959/
)
