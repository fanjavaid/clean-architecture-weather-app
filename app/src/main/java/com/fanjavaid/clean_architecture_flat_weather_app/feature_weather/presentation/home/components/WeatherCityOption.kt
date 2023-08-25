package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fanjavaid.clean_architecture_flat_weather_app.ui.theme.WeatherAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherCityOption(
    modifier: Modifier = Modifier,
    expanded: Boolean,
    cityName: String,
    onChangeCity: () -> Unit,
    onChangeToCurrentLocation: () -> Unit
) {
    TopAppBar(
        modifier = modifier,
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier.width(250.dp),
                    text = cityName,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Light,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                )
                IconButton(onClick = onChangeCity) {
                    Icon(
                        imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                        contentDescription = "Change city",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        },
        actions = {
            IconButton(
                modifier = Modifier,
                onClick = onChangeToCurrentLocation
            ) {
                Icon(
                    imageVector = Icons.Default.MyLocation,
                    contentDescription = "Use my location",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    )
}

@Preview
@Composable
fun WeatherCityOptionPreview() {
    WeatherAppTheme {
        WeatherCityOption(
            cityName = "Jakarta Selatan, Jakarta, Indonesiaaaaaaa aa aaaa",
            expanded = false,
            onChangeCity = {},
            onChangeToCurrentLocation = {}
        )
    }
}