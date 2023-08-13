package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fanjavaid.clean_architecture_flat_weather_app.R
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.Weather
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.presentation.util.WeatherConditionImage
import com.fanjavaid.clean_architecture_flat_weather_app.ui.theme.WeatherAppTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun WeatherForecastDay(
    modifier: Modifier = Modifier,
    forecasts: List<Weather>
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                MaterialTheme.colorScheme.secondaryContainer,
                MaterialTheme.shapes.medium
            ),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        forecasts.forEach {
            WeatherForecastListItem(
                date = it.dt.toLong() * 1_000,
                temperatureC = it.main?.temp ?: 0.0,
                condition = it.weatherData?.firstOrNull()?.main
            )
        }
    }
}

@Composable
fun WeatherForecastListItem(
    modifier: Modifier = Modifier,
    date: Long,
    temperatureC: Double,
    condition: String?
) {
    Column(
        modifier = modifier.height(120.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = SimpleDateFormat("EEE", Locale.getDefault()).format(Date(date)).uppercase(),
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSecondaryContainer
        )
        Box(modifier = Modifier.heightIn(min = 32.dp)) {
            condition?.let {
                val imageRes = WeatherConditionImage.icons[it] ?: R.mipmap.ic_launcher_round
                Image(
                    modifier = Modifier.size(32.dp),
                    imageVector = ImageVector.vectorResource(id = imageRes),
                    contentDescription = condition,
                )
            }
        }
        Text(
            text = "$temperatureC°",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSecondaryContainer
        )
    }
}

@Composable
fun WeatherForecastListItemShimmer(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .background(
                MaterialTheme.colorScheme.surface,
                MaterialTheme.shapes.medium
            )
            .height(120.dp),
        tonalElevation = 16.dp,
        shape = MaterialTheme.shapes.medium
    ) {
        Spacer(modifier = Modifier)
    }
}


@Preview(showBackground = false)
@Composable
fun WeatherForecastDayPreview() {
    WeatherAppTheme {
        WeatherForecastDay(
            forecasts = listOf()
        )
    }
}