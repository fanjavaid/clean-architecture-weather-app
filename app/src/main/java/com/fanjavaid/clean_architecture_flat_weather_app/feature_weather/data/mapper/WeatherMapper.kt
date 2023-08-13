package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.mapper

import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model.WeatherNetworkResponse
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.mapper.BaseDomainMapper
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.Weather
import javax.inject.Inject

class WeatherMapper @Inject constructor(
    private val cloudsMapper: CloudsMapper,
    private val coordMapper: CoordMapper,
    private val mainMapper: MainMapper,
    private val sysMapper: SysMapper,
    private val windMapper: WindMapper,
    private val weatherDataMapper: WeatherDataMapper
) : BaseDomainMapper<WeatherNetworkResponse, Weather> {
    override fun mapToDomainModel(data: WeatherNetworkResponse): Weather {
        return Weather(
            base = data.base,
            clouds = data.clouds?.let { cloudsMapper.mapToDomainModel(it) },
            cod = data.cod,
            coord = data.coord?.let { coordMapper.mapToDomainModel(it) },
            dt = data.dt,
            id = data.id,
            main = data.main?.let { mainMapper.mapToDomainModel(it) },
            name = data.name,
            sys = data.sys?.let { sysMapper.mapToDomainModel(it) },
            timezone = data.timezone,
            visibility = data.visibility,
            weatherData = data.weatherData?.map(weatherDataMapper::mapToDomainModel),
            wind = data.wind?.let { windMapper.mapToDomainModel(it) }
        )
    }
}
