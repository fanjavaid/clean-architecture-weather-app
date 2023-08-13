package com.fanjavaid.clean_architecture_flat_weather_app.core.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RetrofitWeatherApi

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RetrofitCityApi

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RetrofitNewsApi
