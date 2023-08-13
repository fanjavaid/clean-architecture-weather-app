package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.usecases

import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.news.News
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.repositories.NewsRepository
import javax.inject.Inject

class GetWeatherNews @Inject constructor(
    private val newsRepository: NewsRepository,
) {

    operator suspend fun invoke(): List<News> {
        return newsRepository.getWeatherNews()
    }
}
