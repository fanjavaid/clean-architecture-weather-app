package com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.data.mapper

import com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.data.model.AirQualityIndexNetworkResponse
import com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.domain.model.AirQualityDominantPollution
import com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.domain.model.AirQualityForecast
import com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.domain.model.AirQualityForecastValue
import com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.domain.model.AirQualityIndex
import com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.domain.model.AirQualityMetadata
import com.fanjavaid.clean_architecture_flat_weather_app.shared.mapper.BaseDomainMapper
import javax.inject.Inject

class AirQualityIndexMapper @Inject constructor() : BaseDomainMapper<AirQualityIndexNetworkResponse, AirQualityIndex> {
    override fun mapToDomainModel(data: AirQualityIndexNetworkResponse): AirQualityIndex {
        val aqiData = data.data
        return AirQualityIndex(
            index = aqiData?.aqi ?: 0,
            dominantPollution = AirQualityDominantPollution(
                name = aqiData?.dominentPol,
                value = when (aqiData?.dominentPol) {
                    "pm10" -> aqiData.iaqi?.pm10?.value ?: 0.0
                    "pm25" -> aqiData.iaqi?.pm25?.value ?: 0.0
                    "o3" -> aqiData.iaqi?.o3?.value ?: 0.0
                    "no2" -> aqiData.iaqi?.no2?.value ?: 0.0
                    "so2" -> aqiData.iaqi?.so2?.value ?: 0.0
                    "co" -> aqiData.iaqi?.co?.value ?: 0.0
                    else -> 0.0
                }
            ),
            forecast = listOf(
                AirQualityForecast(
                    type = "pm25",
                    values = aqiData?.forecast?.daily?.pm25?.map {
                        AirQualityForecastValue(
                            min = it?.min ?: 0,
                            max = it?.max ?: 0,
                            average = it?.avg ?: 0
                        )
                    }.orEmpty()
                ),
                AirQualityForecast(
                    type = "pm10",
                    values = aqiData?.forecast?.daily?.pm10?.map {
                        AirQualityForecastValue(
                            min = it?.min ?: 0,
                            max = it?.max ?: 0,
                            average = it?.avg ?: 0
                        )
                    }.orEmpty()
                ),
                AirQualityForecast(
                    type = "o3",
                    values = aqiData?.forecast?.daily?.o3?.map {
                        AirQualityForecastValue(
                            min = it?.min ?: 0,
                            max = it?.max ?: 0,
                            average = it?.avg ?: 0
                        )
                    }.orEmpty()
                )
            ),
            metadata = AirQualityMetadata(
                attribution = aqiData?.attributions?.firstOrNull()?.name,
                resultUrl = aqiData?.city?.url
            ),
        )
    }
}
