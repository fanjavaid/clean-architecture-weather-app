package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fanjavaid.clean_architecture_flat_weather_app.ui.theme.WeatherAppTheme

@Composable
fun WeatherCityOption(
    modifier: Modifier = Modifier,
    cityName: String,
    onChangeCity: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(MaterialTheme.colorScheme.primary),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = cityName,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.Light,
                color = MaterialTheme.colorScheme.onPrimary
            )
        )
        IconButton(onClick = onChangeCity) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = "Change city",
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@Preview
@Composable
fun WeatherCityOptionPreview() {
    WeatherAppTheme {
        WeatherCityOption(cityName = "Jakarta") {

        }
    }
}