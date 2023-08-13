package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.mapper.news

import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model.news.GuardianNewsNetworkResponse
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.mapper.BaseDomainMapper
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.news.News
import java.text.SimpleDateFormat
import javax.inject.Inject

class NewsMapper @Inject constructor() : BaseDomainMapper<GuardianNewsNetworkResponse, List<News>> {

    private val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")

    override fun mapToDomainModel(data: GuardianNewsNetworkResponse): List<News> {
        return data.response.results.map {
            News(
                id = it.id,
                headline = it.fields.headline,
                trailText = it.fields.trailText,
                thumbnail = it.fields.thumbnail,
                lastUpdate = try {
                    simpleDateFormat.parse(it.fields.lastModified)
                } catch (e: Exception) {
                    null
                },
                by = it.fields.byline,
                body = it.fields.bodyText,
            )
        }
    }
}
