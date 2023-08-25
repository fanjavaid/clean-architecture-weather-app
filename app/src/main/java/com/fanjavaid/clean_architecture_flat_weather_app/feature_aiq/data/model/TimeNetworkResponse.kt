package com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.data.model


import com.google.gson.annotations.SerializedName

data class TimeNetworkResponse(
    @SerializedName("iso")
    val iso: String?, // 2023-08-25T14:00:00+07:00
    @SerializedName("s")
    val s: String?, // 2023-08-25 14:00:00
    @SerializedName("tz")
    val tz: String?, // +07:00
    @SerializedName("v")
    val v: Int? // 1692972000
)