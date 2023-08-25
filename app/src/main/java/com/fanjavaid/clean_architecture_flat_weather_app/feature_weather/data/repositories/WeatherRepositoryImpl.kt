package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.repositories

import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.mapper.ForecastMapper
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.mapper.WeatherMapper
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model.WeatherNetworkResponse
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.source.WeatherNetworkService
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.Forecast
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.Weather
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.repositories.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val appDispatchers: Dispatchers,
    private val weatherNetworkService: WeatherNetworkService,
    private val weatherMapper: WeatherMapper,
    private val forecastMapper: ForecastMapper
) : WeatherRepository {

    override suspend fun getCurrentWeather(latitude: Double, longitude: Double): Weather? {
        return withContext(appDispatchers.IO) {
            try {
                val responseData = weatherNetworkService.getCurrentWeather(latitude, longitude)
                weatherMapper.mapToDomainModel(responseData)
            } catch (e: Exception) {
                null
            }
        }
    }

    override suspend fun getForecastWeather(latitude: Double, longitude: Double): Forecast? {
        return withContext(appDispatchers.IO) {
            try {
                val responseData = weatherNetworkService.getForecastWeather(latitude, longitude)
                val simpleDateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
                val groupedForecast = responseData.list.groupBy {
                    simpleDateFormat.format(Date(it.dt * 1000L))
                }

                val weathers = mutableListOf<WeatherNetworkResponse>()
                groupedForecast.values.forEach {
                    weathers.add(it.first())
                }

                val updatedResponseData = responseData.copy(list = weathers)

                forecastMapper.mapToDomainModel(updatedResponseData)
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }
    }
}
