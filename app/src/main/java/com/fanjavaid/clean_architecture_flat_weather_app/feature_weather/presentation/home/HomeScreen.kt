package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.presentation.components.WeatherCityOption
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.presentation.components.WeatherCurrentInfo
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.presentation.components.WeatherForecastDay
import com.fanjavaid.clean_architecture_flat_weather_app.ui.theme.WeatherAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            WeatherCityOption(cityName = "Jakarta") {

            }
            WeatherCurrentInfo(
                conditionImageUrl = "",
                conditionText = "Sunny",
                temperatureC = 15.6,
                dateTime = System.currentTimeMillis(),
                humidity = 69.8,
                wind = "16 km/h",
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
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    WeatherAppTheme(darkTheme = true) {
        HomeScreen()
    }
}