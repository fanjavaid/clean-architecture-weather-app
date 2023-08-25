package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.presentation.home

import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.presentation.home.components.WeatherCitySearch
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.presentation.home.components.WeatherCurrentInfo
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.presentation.home.components.WeatherCurrentInfoShimmer
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.presentation.home.components.WeatherForecastDay
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.presentation.home.components.WeatherForecastListItemShimmer
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.presentation.home.components.WeatherNewsList
import com.fanjavaid.clean_architecture_flat_weather_app.ui.theme.WeatherAppTheme
import kotlin.math.ceil

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val cityListState by viewModel.cityListState.collectAsStateWithLifecycle()
    val currentWeatherState by viewModel.currentWeatherState.collectAsStateWithLifecycle()
    val forecastState by viewModel.forecastState.collectAsStateWithLifecycle()
    val newsState by viewModel.newsState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        WeatherCitySearch(
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 16.dp),
            loading = cityListState.isLoading,
            cityName = viewModel.cityName.value,
            results = cityListState.cities,
            onValueChange = {
                viewModel.cityName.value = it
                if (it.isBlank()) viewModel.onEvent(HomeEvent.ClearResult)
            },
            onSearch = {
                viewModel.onEvent(HomeEvent.SearchCity(it))
            },
            onSelect = {
                viewModel.onEvent(HomeEvent.SelectCity(it))
            }
        )

        AnimatedContent(targetState = currentWeatherState.isLoading, label = "") { isLoading ->
            if (isLoading) {
                WeatherCurrentInfoShimmer(modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp))
            } else {
                WeatherCurrentInfo(
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
                    location = viewModel.selectedCity.value,
                    condition = currentWeatherState.weather?.weatherData?.firstOrNull(),
                    conditionText = currentWeatherState.weather?.weatherData?.get(0)?.description.orEmpty(),
                    temperatureC = ceil(currentWeatherState.weather?.main?.temp ?: 0.0).toInt(),
                    dateTime = (currentWeatherState.weather?.dt?.toLong() ?: 0) * 1_000
                )
            }
        }
        AnimatedContent(targetState = forecastState.isLoading, label = "") { isLoading ->
            if (isLoading) {
                WeatherForecastListItemShimmer(modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp))
            } else {
                WeatherForecastDay(
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
                    forecasts = forecastState.forecast?.list.orEmpty()
                )
            }
        }
        WeatherNewsList(
            modifier = Modifier.padding(
                top = 16.dp,
                start = 16.dp,
                end = 16.dp
            ),
            newsList = newsState.newsList.orEmpty(),
            onClickItem = { url ->
                val chromeIntent = CustomTabsIntent.Builder().build()
                chromeIntent.launchUrl(context, Uri.parse(url))
            }
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    WeatherAppTheme(darkTheme = true) {
        HomeScreen()
    }
}