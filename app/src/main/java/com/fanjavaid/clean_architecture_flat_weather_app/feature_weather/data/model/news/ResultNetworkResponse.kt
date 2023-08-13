package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model.news

import com.google.gson.annotations.SerializedName

data class ResultNetworkResponse(
    @SerializedName("apiUrl")
    val apiUrl: String, // https://content.guardianapis.com/world/2023/jul/13/more-extreme-weather-across-us
    @SerializedName("fields")
    val fields: FieldsNetworkResponse,
    @SerializedName("id")
    val id: String, // world/2023/jul/13/more-extreme-weather-across-us
    @SerializedName("webPublicationDate")
    val webPublicationDate: String, // 2023-07-14T11:57:35Z
    @SerializedName("webUrl")
    val webUrl: String // https://www.theguardian.com/world/2023/jul/13/more-extreme-weather-across-us
)