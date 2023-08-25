package com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.data.repositories

import com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.data.mapper.AirQualityIndexMapper
import com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.data.source.AirQualityService
import com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.domain.model.AirQualityIndex
import com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.domain.repositories.AirQualityRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AirQualityRepositoryImpl @Inject constructor(
    private val appDispatchers: Dispatchers,
    private val airQualityService: AirQualityService,
    private val airQualityIndexMapper: AirQualityIndexMapper
) : AirQualityRepository {

    override suspend fun getAirQualityIndex(latitude: Double, longitude: Double): AirQualityIndex? {
        return withContext(appDispatchers.IO) {
            try {
                val response = airQualityService.getAirQualityIndex(latitude, longitude)
                airQualityIndexMapper.mapToDomainModel(response)
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }
    }
}