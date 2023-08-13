package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.source

import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model.news.GuardianNewsNetworkResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GuardianNewsNetworkService {

    /**
     * https://content.guardianapis.com/search?page=2&q=weather
     * &api-key=2ccc85a8-d886-44e5-8157-c7bbe7f57173&&show-fields=headline,trailText,byline,thumbnail,lastModified,bodyText
     */
    @GET("search")
    suspend fun getWeatherNews(
        @Query("q") query: String = "weather",
        @Query("page") page: Int = 1,
        @Query("show-fields") showFields: String = "headline,trailText,byline,thumbnail,lastModified,bodyText"
    ): GuardianNewsNetworkResponse
}