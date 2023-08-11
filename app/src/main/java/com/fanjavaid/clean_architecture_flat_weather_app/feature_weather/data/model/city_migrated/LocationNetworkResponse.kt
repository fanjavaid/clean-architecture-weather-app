package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model.city_migrated

import com.google.gson.annotations.SerializedName

data class LocationNetworkResponse(
    @SerializedName("geohash")
    val geohash: String, // 9q8yyk8yuv26emr0cctm
    @SerializedName("latlon")
    val latlon: LatLongNetworkResponse
)