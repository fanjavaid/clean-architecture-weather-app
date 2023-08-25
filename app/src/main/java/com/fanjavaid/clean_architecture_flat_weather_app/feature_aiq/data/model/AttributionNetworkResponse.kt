package com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.data.model


import com.google.gson.annotations.SerializedName

data class AttributionNetworkResponse(
    @SerializedName("logo")
    val logo: String?, // Indonesia-Badan-Meteorologi-Klimatologi-dan-Geofisika.png
    @SerializedName("name")
    val name: String?, // BMKG | Badan Meteorologi, Klimatologi dan Geofisika
    @SerializedName("url")
    val url: String? // http://www.bmkg.go.id/
)