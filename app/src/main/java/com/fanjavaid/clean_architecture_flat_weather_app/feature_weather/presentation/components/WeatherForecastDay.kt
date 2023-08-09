package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fanjavaid.clean_architecture_flat_weather_app.R
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.presentation.util.formatThreeCharsDay
import com.fanjavaid.clean_architecture_flat_weather_app.ui.theme.WeatherAppTheme
import java.util.Date

@Composable
fun WeatherForecastDay(
    modifier: Modifier = Modifier,
    dateTime: Long,
    conditionImageUrl: String,
    conditionText: String,
    temperatureC: Double,
    humidity: Double,
    wind: String
) {

    Column(
        modifier = modifier
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(MaterialTheme.colorScheme.secondary)
                .padding(8.dp),
            text = Date(dateTime).formatThreeCharsDay().orEmpty().uppercase(),
            style = MaterialTheme.typography.headlineSmall.copy(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSecondary,
                textAlign = TextAlign.Center,
            ),
        )

        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.tertiary)
                .fillMaxSize()
                .padding(vertical = 16.dp, horizontal = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            WeatherTextIconVertical(
                icon = R.drawable.ic_humidity,
                iconSize = 32.dp,
                text = "$temperatureC°"
            )

            Spacer(modifier = Modifier.height(24.dp))

            WeatherTextIconVertical(
                icon = R.drawable.ic_humidity,
                text = "$humidity%"
            )

            Spacer(modifier = Modifier.height(24.dp))

            WeatherTextIconVertical(
                icon = R.drawable.ic_wind,
                text = wind
            )
        }
    }
}

@Preview
@Composable
fun WeatherForecastDayPreview() {
    WeatherAppTheme {
        WeatherForecastDay(
            dateTime = System.currentTimeMillis(),
            conditionImageUrl = "",
            conditionText = "Sunny",
            temperatureC = -19.0,
            humidity = 69.0,
            wind = "50 km/h"
        )
    }
}