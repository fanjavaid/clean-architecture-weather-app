package com.fanjavaid.clean_architecture_flat_weather_app.core.di

import com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.data.repositories.AirQualityRepositoryImpl
import com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.domain.repositories.AirQualityRepository
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.repositories.CityRepositoryImpl
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.repositories.NewsRepositoryImpl
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.repositories.WeatherRepositoryImpl
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.repositories.CityRepository
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.repositories.NewsRepository
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.repositories.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindsWeatherRepository(weatherRepositoryImpl: WeatherRepositoryImpl): WeatherRepository

    @Binds
    @Singleton
    fun bindsCityRepository(cityRepository: CityRepositoryImpl): CityRepository

    @Binds
    @Singleton
    fun bindsNewsRepository(newsRepository: NewsRepositoryImpl): NewsRepository

    @Binds
    @Singleton
    fun bindsAirQualityRepository(airQualityRepository: AirQualityRepositoryImpl): AirQualityRepository
}