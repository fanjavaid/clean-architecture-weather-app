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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.WeatherData
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.presentation.util.WeatherConditionImage
import com.fanjavaid.clean_architecture_flat_weather_app.ui.theme.WeatherAppTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun WeatherCurrentInfo(
    modifier: Modifier = Modifier,
    location: String,
    condition: WeatherData?,
    conditionText: String,
    temperatureC: Int,
    dateTime: Long
) {

    val conditionName = condition?.main

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                MaterialTheme.colorScheme.primaryContainer,
                MaterialTheme.shapes.medium
            )
            .height(200.dp)
            .padding(24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = location,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = SimpleDateFormat("EEE, dd MMM yyyy hh:mm", Locale.getDefault()).format(Date(dateTime)),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(
                    alpha = .75f
                ),
            )
            Text(
                text = "$temperatureC°",
                style = MaterialTheme.typography.displayLarge.copy(
                    fontWeight = FontWeight.Light
                ),
                color = MaterialTheme.colorScheme.onPrimaryContainer,
            )
            Text(
                text = condition?.main.orEmpty(),
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
            )
        }

        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            conditionName?.let {
                val imageRes = WeatherConditionImage.icons[it]
                if (imageRes != null) {
                    Image(
                        imageVector = ImageVector.vectorResource(imageRes),
                        modifier = Modifier.size(100.dp),
                        contentDescription = conditionText
                    )
                }
            }
        }
    }
}

@Composable
fun WeatherCurrentInfoShimmer(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .background(
                MaterialTheme.colorScheme.surface,
                MaterialTheme.shapes.medium
            )
            .height(200.dp),
        tonalElevation = 16.dp,
        shape = MaterialTheme.shapes.medium
    ) {
        Spacer(modifier = Modifier)
    }
}

@Preview(showBackground = false)
@Composable
fun WeatherCurrentInfoPreview() {
    WeatherAppTheme {
        WeatherCurrentInfo(
            location = "Jakarta Selatan, DKI Jakarta, Indonesia",
            condition = WeatherData("", "", 0, ""),
            conditionText = "Sunny",
            temperatureC = 15,
            dateTime = System.currentTimeMillis()
        )
    }
}