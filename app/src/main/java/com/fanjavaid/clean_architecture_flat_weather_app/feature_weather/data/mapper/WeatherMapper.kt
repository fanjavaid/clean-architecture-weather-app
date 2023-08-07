package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.mapper

import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.model.WeatherNetworkResponse
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.mapper.BaseDomainMapper
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.Weather

class WeatherMapper : BaseDomainMapper<WeatherNetworkResponse, Weather> {
    override fun mapToDomainModel(data: WeatherNetworkResponse): Weather {
        return Weather(
            base = data.base,
            clouds = CloudsMapper().mapToDomainModel(data.clouds),
            cod = data.cod,
            coord = CoordMapper().mapToDomainModel(data.coord),
            dt = data.dt,
            id = data.id,
            main = MainMapper().mapToDomainModel(data.main),
            name = data.name,
            sys = SysMapper().mapToDomainModel(data.sys),
            timezone = data.timezone,
            visibility = data.visibility,
            weatherData = data.weatherData.map(WeatherDataMapper()::mapToDomainModel),
            wind = WindMapper().mapToDomainModel(data.wind)
        )
    }
}
