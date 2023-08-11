package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.fanjavaid.clean_architecture_flat_weather_app.R
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.presentation.util.formatSlashShort
import com.fanjavaid.clean_architecture_flat_weather_app.ui.theme.WeatherAppTheme
import java.util.Date

@Composable
fun WeatherCurrentInfo(
    modifier: Modifier = Modifier,
    conditionImageUrl: String,
    conditionText: String,
    temperatureC: Int,
    dateTime: Long,
    humidity: Int,
    wind: String
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(235.dp)
            .padding(24.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.Top
    ) {
        AsyncImage(
            model = conditionImageUrl,
            modifier = Modifier.size(150.dp),
            contentDescription = conditionText
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier
                .fillMaxHeight()
        ) {
            Text(
                text = "$temperatureC°",
                style = MaterialTheme.typography.headlineLarge.copy(
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontWeight = FontWeight.Medium,
                    fontSize = 60.sp
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = Date(dateTime).formatSlashShort().orEmpty(), // TODO: Create formatter
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontWeight = FontWeight.Light
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            WeatherTextIconHorizontal(
                icon = R.drawable.ic_humidity,
                text = "$humidity%"
            )
            Spacer(modifier = Modifier.height(8.dp))
            WeatherTextIconHorizontal(
                icon = R.drawable.ic_wind,
                text = wind
            )
        }
    }
}

@Preview
@Composable
fun WeatherCurrentInfoPreview() {
    WeatherAppTheme {
        WeatherCurrentInfo(
            conditionImageUrl = "",
            conditionText = "Sunny",
            temperatureC = 15,
            dateTime = System.currentTimeMillis(),
            humidity = 69,
            wind = "16 km/h",
        )
    }
}