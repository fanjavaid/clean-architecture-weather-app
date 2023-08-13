package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.repositories

import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.news.News

interface NewsRepository {

    suspend fun getWeatherNews(): List<News>
}