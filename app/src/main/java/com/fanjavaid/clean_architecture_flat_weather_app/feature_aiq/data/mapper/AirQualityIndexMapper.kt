package com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.data.mapper

import com.fanjavaid.clean_architecture_flat_weather_app.core.mapper.BaseDomainMapper
import com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.data.model.AirPollutionNetworkResponse
import com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.domain.model.air_quality.AirQualityComponent
import com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.domain.model.air_quality.AirQualityIndex
import javax.inject.Inject

class AirQualityIndexMapper @Inject constructor() :
    BaseDomainMapper<AirPollutionNetworkResponse, List<AirQualityIndex>> {
    override fun mapToDomainModel(data: AirPollutionNetworkResponse): List<AirQualityIndex> {
        return data.list.map {
            AirQualityIndex(
                qualityIndex = it.main.aqi,
                dateTime = it.dt * 1_000L,
                components = listOf(
                    AirQualityComponent(
                        name = "CO",
                        desc = "Carbon monoxide",
                        value = it.components.co
                    ),
                    AirQualityComponent(
                        name = "NO",
                        desc = "Nitrogen monoxide",
                        value = it.components.no
                    ),
                    AirQualityComponent(
                        name = "NO2",
                        desc = "Nitrogen dioxide",
                        value = it.components.no2
                    ),
                    AirQualityComponent(
                        name = "PM 10",
                        desc = "Particulates",
                        value = it.components.pm10
                    ),
                    AirQualityComponent(
                        name = "PM 2,5",
                        desc = "Particulates",
                        value = it.components.pm25
                    ),
                    AirQualityComponent(
                        name = "O3",
                        desc = "Ozone",
                        value = it.components.o3
                    ),
                    AirQualityComponent(
                        name = "NH3",
                        desc = "Ammonia",
                        value = it.components.nh3
                    ),
                    AirQualityComponent(
                        name = "SO2",
                        desc = "Sulphur dioxide",
                        value = it.components.so2
                    ),
                )
            )
        }
    }
}

