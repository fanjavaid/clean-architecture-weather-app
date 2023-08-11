package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model.city_migrated

import com.google.gson.annotations.SerializedName

data class CitySearchResultNetworkResponse(
    @SerializedName("_links")
    val links: LinksNetworkResponse,
    @SerializedName("matching_full_name")
    val matchingFullName: String // San Francisco, California, United States
)