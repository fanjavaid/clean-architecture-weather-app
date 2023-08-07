package com.fanjavaid.clean_architecture_flat_weather_app.core.di

import com.fanjavaid.clean_architecture_flat_weather_app.BuildConfig
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.mapper.ForecastMapper
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.mapper.WeatherMapper
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.source.WeatherNetworkService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val urlWithApiKey = chain.request().url.newBuilder()
                    .addQueryParameter("appid", BuildConfig.WEATHER_API_KEY)
                    .build()
                val request = chain.request().newBuilder()
                    .url(urlWithApiKey)
                    .build()
                chain.proceed(request)
            }
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()
    }

    @Provides
    @Singleton
    fun providesRetrofit(httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://pro.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
    }

    @Provides
    @Singleton
    fun providesWeatherService(retrofit: Retrofit): WeatherNetworkService {
        return retrofit.create(WeatherNetworkService::class.java)
    }

    @Provides
    @Singleton
    fun providesAppDispatchers(): Dispatchers = Dispatchers

    // Mapper
    @Provides
    @Singleton
    fun providesWeatherMapper(): WeatherMapper = WeatherMapper()

    @Provides
    @Singleton
    fun providesForecastMapper(): ForecastMapper = ForecastMapper()
}