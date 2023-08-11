package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.source

import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model.city_migrated.CityApiResultNetworkResponse
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model.city_migrated.CityDetailNetworkResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CityNetworkService {

    @GET("cities")
    suspend fun searchCity(
        @Query("search") keyword: String,
        @Query("limit") limit: Int = 10,
    ): CityApiResultNetworkResponse

    @GET("cities/{cityId}")
    suspend fun getCityDetailById(@Path("cityId") cityId: String): CityDetailNetworkResponse
}
