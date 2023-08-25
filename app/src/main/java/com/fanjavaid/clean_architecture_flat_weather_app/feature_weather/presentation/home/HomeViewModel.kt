package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.presentation.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.Forecast
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.Weather
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.city.City
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.news.News
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.usecases.GetCityDetailById
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.usecases.GetCurrentWeather
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.usecases.GetForecastWeather
import com.fanjavaid.clean_architecture_flat_weather_app.shared.domain.GetLastSavedCity
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.usecases.GetWeatherNews
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.usecases.SearchCity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val searchCity: SearchCity,
    private val getCityDetailById: GetCityDetailById,
    private val getCurrentWeather: GetCurrentWeather,
    private val getForecastWeather: GetForecastWeather,
    private val getWeatherNews: GetWeatherNews,
    private val getLastSavedCity: GetLastSavedCity
) : ViewModel() {

    var cityName = mutableStateOf("")
    var selectedCity = mutableStateOf("")

    private var _cityListsState = MutableStateFlow<CityListState>(CityListState())
    val cityListState = _cityListsState.asStateFlow()

    private var _currentWeatherState = MutableStateFlow<CurrentWeatherUiState>(CurrentWeatherUiState())
    val currentWeatherState = _currentWeatherState.asStateFlow()

    private var _forecastState = MutableStateFlow<ForecastUiState>(ForecastUiState())
    val forecastState = _forecastState.asStateFlow()

    private var _newsState = MutableStateFlow<WeatherNewsUiState>(WeatherNewsUiState())
    val newsState = _newsState.asStateFlow()

    init {
        viewModelScope.launch {
            getLastSavedCity.invoke().collectLatest {
                selectedCity.value = it.name
                getWeatherData(it.latitude, it.longitude)
            }
        }
        getNews()
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.SearchCity -> getCityList(event.keyword)

            is HomeEvent.SelectCity -> viewModelScope.launch {
                resetSearchState()
                val cityDetail = getCityDetailById.invoke(event.city.geoId)
                if (cityDetail != null) {
                    selectedCity.value = cityDetail.name
                    getWeatherData(
                        latitude = cityDetail.latitude,
                        longitude = cityDetail.longitude
                    )
                }
            }

            is HomeEvent.UpdateWeather -> viewModelScope.launch {
            }

            is HomeEvent.ClearResult -> {
                _cityListsState.update {
                    it.copy(cities = null, isLoading = false)
                }
            }
        }
    }

    private fun resetSearchState() {
        cityName.value = ""
        _cityListsState.update {
            it.copy(cities = null, isLoading = false)
        }
    }

    private fun getCityList(keyword: String) = viewModelScope.launch {
        _cityListsState.update {
            it.copy(isLoading = true)
        }
        val cities = searchCity.invoke(keyword)
        _cityListsState.update {
            it.copy(cities = cities, isLoading = false)
        }
    }

    private fun getWeatherData(latitude: Double, longitude: Double) = viewModelScope.launch {
        // Current weather
        _currentWeatherState.update {
            it.copy(isLoading = true)
        }
        _forecastState.update {
            it.copy(isLoading = true)
        }

        val weather = async {
            getCurrentWeather.invoke(
                latitude = latitude,
                longitude = longitude
            )
        }
        val forecast = async {
            getForecastWeather.invoke(
                latitude = latitude,
                longitude = longitude
            )
        }
        _currentWeatherState.update {
            it.copy(
                weather = weather.await(),
                isLoading = false
            )
        }
        _forecastState.update {
            it.copy(
                forecast = forecast.await(),
                isLoading = false
            )
        }
    }

    private fun getNews() = viewModelScope.launch {
        val news = getWeatherNews.invoke()
        _newsState.update {
            it.copy(
                newsList = news,
                isLoading = false
            )
        }
    }

    data class CityListState(
        val cities: List<City>? = null,
        val isLoading: Boolean = false
    )

    data class CurrentWeatherUiState(
        val weather: Weather? = null,
        val isLoading: Boolean = true // Because initial state is load the data
    )

    data class ForecastUiState(
        val forecast: Forecast? = null,
        val isLoading: Boolean = true // Because initial state is load the data
    )

    data class WeatherNewsUiState(
        val newsList: List<News>? = null,
        val isLoading: Boolean = true // Because initial state is load the data
    )
}
