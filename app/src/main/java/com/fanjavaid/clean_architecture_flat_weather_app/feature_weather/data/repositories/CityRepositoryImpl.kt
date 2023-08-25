package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.repositories

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.mapper.city.CityDetailMapper
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.mapper.city.CityMapper
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.source.CityNetworkService
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.utils.Constants
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.city.City
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.city.CityDetail
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.repositories.CityRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CityRepositoryImpl @Inject constructor(
    private val appDispatchers: Dispatchers,
    private val cityMapper: CityMapper,
    private val cityDetailMapper: CityDetailMapper,
    private val cityNetworkService: CityNetworkService,
    private val dataStore: DataStore<Preferences>
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
                val companyDetail = cityDetailMapper.mapToDomainModel(responseData)

                // Save to datastore
                dataStore.edit {
                    it[Constants.cityName] = companyDetail.name
                    it[Constants.latPrefKey] = companyDetail.latitude
                    it[Constants.lonPrefKey] = companyDetail.longitude
                }

                companyDetail
            } catch (e: Exception) {
                Log.e("CityRepository", "getCityDetailById: ${e.message}")
                null
            }
        }
    }

    override suspend fun getLastSavedCity(): Flow<CityDetail> {
        return dataStore.data.map {
            CityDetail(
                name = it[Constants.cityName].orEmpty(),
                latitude = it[Constants.latPrefKey] ?: 0.0,
                longitude = it[Constants.lonPrefKey] ?: 0.0
            )
        }
    }
}