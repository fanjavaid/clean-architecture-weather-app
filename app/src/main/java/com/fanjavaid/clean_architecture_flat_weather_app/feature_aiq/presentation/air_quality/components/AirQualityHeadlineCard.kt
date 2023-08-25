package com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.presentation.air_quality.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AirQualityHeadlineCard(
    modifier: Modifier = Modifier,
    qualityIndex: Double,
    qualityStatus: String,
    qualityDesc: String
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                MaterialTheme.colorScheme.secondaryContainer,
                MaterialTheme.shapes.medium
            )
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Air Quality Index",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onSecondaryContainer
        )
        Text(
            text = qualityIndex.toString(),
            style = MaterialTheme.typography.displayLarge,
            fontWeight = FontWeight.Light,
            color = MaterialTheme.colorScheme.onSecondaryContainer
        )
        Text(
            text = qualityStatus,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSecondaryContainer
        )
        Text(
            text = qualityDesc,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSecondaryContainer
        )
    }
}

@Preview
@Composable
fun AirQualityHeadlineCardPreview() {
    AirQualityHeadlineCard(
        qualityIndex = 160.5,
        qualityStatus = "Unhealthy",
        qualityDesc = "Increase likelihood of adverse effects.\n" +
            "Aggravation to the heart and lunge among\n" +
            "general public."
    )
}