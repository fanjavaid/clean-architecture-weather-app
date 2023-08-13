package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.repositories

import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.mapper.news.NewsMapper
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.source.GuardianNewsNetworkService
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.news.News
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.repositories.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val appDispatchers: Dispatchers,
    private val newsNetworkService: GuardianNewsNetworkService,
    private val newsMapper: NewsMapper
) : NewsRepository {

    override suspend fun getWeatherNews(): List<News> {
        return withContext(appDispatchers.IO) {
            try {
                val response = newsNetworkService.getWeatherNews()
                newsMapper.mapToDomainModel(response)
            } catch (e: Exception) {
                e.printStackTrace()
                emptyList<News>()
            }
        }
    }
}