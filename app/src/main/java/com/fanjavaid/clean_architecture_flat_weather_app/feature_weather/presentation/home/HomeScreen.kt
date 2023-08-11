package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.presentation.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.city.City
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.presentation.components.WeatherCityOption
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.presentation.components.WeatherCitySearch
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.presentation.components.WeatherCurrentInfo
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.presentation.components.WeatherForecastDay
import com.fanjavaid.clean_architecture_flat_weather_app.ui.theme.WeatherAppTheme
import kotlin.math.ceil

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {

    var showSearch by remember {
        mutableStateOf(false)
    }

    var cityName by remember {
        mutableStateOf("")
    }

    var selectedCity by remember {
        mutableStateOf(City("-1", "Unknown"))
    }

    val results = viewModel.cities.value
    val currentWeather = viewModel.currentWeather.value
    val uiEvent by viewModel.eventState.collectAsState(initial = null)

    Scaffold(
        modifier = modifier
    ) { paddingValues ->
        Box {
            Column(
                modifier = Modifier.padding(paddingValues)
            ) {
                WeatherCityOption(
                    cityName = selectedCity.cityName,
                    expanded = showSearch,
                    onChangeCity = {
                        showSearch = !showSearch
                    },
                    onChangeToCurrentLocation = {}
                )
                AnimatedVisibility(visible = showSearch) {
                    Box(modifier = Modifier.height(56.dp))
                }
                WeatherCurrentInfo(
                    conditionImageUrl = "https://openweathermap.org/img/wn/" +
                        "${currentWeather?.weatherData?.get(0)?.icon}@2x.png",
                    conditionText = currentWeather?.weatherData?.get(0)?.description.orEmpty(),
                    temperatureC = ceil(currentWeather?.main?.temp ?: 0.0).toInt(),
                    dateTime = System.currentTimeMillis(),
                    humidity = currentWeather?.main?.humidity ?: 0,
                    wind = "${currentWeather?.wind?.speed} km/h",
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    repeat(4) {
                        WeatherForecastDay(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight(),
                            dateTime = System.currentTimeMillis(),
                            conditionImageUrl = "",
                            conditionText = "Sunny",
                            temperatureC = -19.0,
                            humidity = 69.0,
                            wind = "50 km/h"
                        )
                        Divider(
                            color = MaterialTheme.colorScheme.secondary,
                            modifier = Modifier
                                .fillMaxHeight()  //fill the max height
                                .width(1.dp)
                        )
                    }
                }
            }

            AnimatedVisibility(
                visible = showSearch,
                enter = fadeIn() + slideInVertically(initialOffsetY = { -50 }),
                exit = fadeOut() + slideOutVertically(targetOffsetY = { -50 })
            ) {
                WeatherCitySearch(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 80.dp),
                    cityName = cityName,
                    loading = uiEvent is HomeViewModel.UiEvent.Loading,
                    results = results,
                    onValueChange = {
                        cityName = it
                    },
                    onSearch = {
                        viewModel.onEvent(HomeEvent.SearchCity(it))
                    },
                    onSelect = {
                        viewModel.onEvent(HomeEvent.SelectCity(it))
                        selectedCity = it
                        showSearch = false
                        cityName = ""
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    WeatherAppTheme(darkTheme = true) {
        HomeScreen()
    }
}