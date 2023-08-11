package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model.city_migrated

import com.google.gson.annotations.SerializedName

data class LatLongNetworkResponse(
    @SerializedName("latitude")
    val latitude: Double, // 37.77493
    @SerializedName("longitude")
    val longitude: Double // -122.41942
)