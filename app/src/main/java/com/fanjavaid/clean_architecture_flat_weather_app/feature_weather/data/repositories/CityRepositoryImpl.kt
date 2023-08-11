package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.repositories

import android.util.Log
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.mapper.city.CityDetailMapper
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.mapper.city.CityMapper
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.source.CityNetworkService
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.city.City
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.city.CityDetail
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.repositories.CityRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CityRepositoryImpl @Inject constructor(
    private val appDispatchers: Dispatchers,
    private val cityMapper: CityMapper,
    private val cityDetailMapper: CityDetailMapper,
    private val cityNetworkService: CityNetworkService
) : CityRepository {

    override suspend fun searchCity(keyword: String): List<City> {
        return withContext(appDispatchers.IO) {
            try {
                val responseData = cityNetworkService.searchCity(keyword)
                cityMapper.mapToDomainModel(responseData.embedded)
            } catch (e: Exception) {
                Log.e("CityRepository", "searchCity: ${e.message}")
                emptyList()
            }
        }
    }

    override suspend fun getCityDetailById(cityId: String): CityDetail? {
        return withContext(appDispatchers.IO) {
            try {
                val responseData = cityNetworkService.getCityDetailById(cityId)
                cityDetailMapper.mapToDomainModel(responseData)
            } catch (e: Exception) {
                Log.e("CityRepository", "getCityDetailById: ${e.message}")
                null
            }
        }
    }
}