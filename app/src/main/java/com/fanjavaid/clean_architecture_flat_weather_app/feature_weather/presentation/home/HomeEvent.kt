package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.presentation.home

import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.city.City

sealed class HomeEvent {
    data class SearchCity(val keyword: String) : HomeEvent()
    object ClearResult : HomeEvent()
    data class SelectCity(val city: City) : HomeEvent()
    data class UpdateWeather(val city: String) : HomeEvent()
}
