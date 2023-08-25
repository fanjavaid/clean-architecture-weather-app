package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.repositories

import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.city.City
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.city.CityDetail
import kotlinx.coroutines.flow.Flow

interface CityRepository {

    suspend fun searchCity(keyword: String): List<City>

    suspend fun getCityDetailById(cityId: String): CityDetail?

    suspend fun getLastSavedCity(): Flow<CityDetail>
}
