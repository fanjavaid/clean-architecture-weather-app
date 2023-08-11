package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.presentation.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.Weather
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.city.City
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.usecases.GetCityDetailById
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.usecases.GetCurrentWeather
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.usecases.SearchCity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val searchCity: SearchCity,
    private val getCityDetailById: GetCityDetailById,
    private val getCurrentWeather: GetCurrentWeather
) : ViewModel() {

    var cities = mutableStateOf<List<City>?>(null)
        private set

    var currentWeather = mutableStateOf<Weather?>(null)
        private set

    private var _eventState = MutableSharedFlow<UiEvent>()
    val eventState = _eventState.asSharedFlow()

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.SearchCity -> viewModelScope.launch {
                _eventState.emit(UiEvent.Loading)
                cities.value = searchCity.invoke(event.keyword)
                _eventState.emit(UiEvent.Done)
            }

            is HomeEvent.SelectCity -> viewModelScope.launch {
                cities.value = null // reset
                val cityDetail = getCityDetailById.invoke(event.city.geoId)
                if (cityDetail != null) {
                    currentWeather.value = getCurrentWeather.invoke(
                        latitude = cityDetail.latitude,
                        longitude = cityDetail.longitude
                    )
                }
            }

            is HomeEvent.UpdateWeather -> viewModelScope.launch {
            }
        }
    }

    sealed class UiEvent {
        object Loading : UiEvent()
        object Done : UiEvent()
    }
}
