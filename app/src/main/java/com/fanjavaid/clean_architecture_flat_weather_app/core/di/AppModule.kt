package com.fanjavaid.clean_architecture_flat_weather_app.core.di

import com.fanjavaid.clean_architecture_flat_weather_app.BuildConfig
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.source.CityNetworkService
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.data.source.GuardianNewsNetworkService
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
                    .addQueryParameter("units", "metric")
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

    @RetrofitWeatherApi
    @Provides
    @Singleton
    fun providesRetrofit(httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
    }

    @RetrofitCityApi
    @Provides
    @Singleton
    fun providesRetrofitCity(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.teleport.org/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(
                        HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.BODY
                        }
                    )
                    .build()
            )
            .build()
    }

    @RetrofitNewsApi
    @Provides
    @Singleton
    fun providesRetrofitNews(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://content.guardianapis.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor { chain ->
                        val urlWithApiKey = chain.request().url.newBuilder()
                            .addQueryParameter("api-key", BuildConfig.GUARDIAN_API_KEY)
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
            )
            .build()
    }

    @Provides
    @Singleton
    fun providesWeatherService(@RetrofitWeatherApi retrofit: Retrofit): WeatherNetworkService {
        return retrofit.create(WeatherNetworkService::class.java)
    }

    @Provides
    @Singleton
    fun providesCityService(@RetrofitCityApi retrofit: Retrofit): CityNetworkService {
        return retrofit.create(CityNetworkService::class.java)
    }

    @Provides
    @Singleton
    fun providesNewsService(@RetrofitNewsApi retrofit: Retrofit): GuardianNewsNetworkService {
        return retrofit.create(GuardianNewsNetworkService::class.java)
    }

    @Provides
    @Singleton
    fun providesAppDispatchers(): Dispatchers = Dispatchers
}