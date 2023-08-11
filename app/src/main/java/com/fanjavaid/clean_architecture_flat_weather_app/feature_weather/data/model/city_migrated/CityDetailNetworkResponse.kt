package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model.city_migrated

import com.google.gson.annotations.SerializedName

data class CityDetailNetworkResponse(
    @SerializedName("full_name")
    val fullName: String, // San Francisco, California, United States
    @SerializedName("geoname_id")
    val geonameId: Int, // 5391959
    @SerializedName("location")
    val location: LocationNetworkResponse,
    @SerializedName("name")
    val name: String // San Francisco
)