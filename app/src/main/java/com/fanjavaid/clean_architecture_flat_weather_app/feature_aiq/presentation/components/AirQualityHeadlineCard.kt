package com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.presentation.components

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fanjavaid.clean_architecture_flat_weather_app.ui.theme.dark_DangerDarkerColor
import com.fanjavaid.clean_architecture_flat_weather_app.ui.theme.dark_onDangerDarkerColor

@Composable
fun AirQualityHeadlineCard(
    modifier: Modifier = Modifier,
    color: Color,
    textColor: Color,
    qualityIndex: Int,
    qualityStatus: String,
    qualityDesc: String
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color,
                MaterialTheme.shapes.medium
            )
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Air Quality Index",
            style = MaterialTheme.typography.headlineMedium,
            color = textColor
        )
        Text(
            text = qualityIndex.toString(),
            style = MaterialTheme.typography.displayMedium,
            fontWeight = FontWeight.Bold,
            color = textColor
        )
        Text(
            text = qualityStatus,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = textColor
        )
        Text(
            text = qualityDesc,
            style = MaterialTheme.typography.bodyMedium,
            color = textColor
        )
    }
}

@Preview
@Composable
fun AirQualityHeadlineCardPreview() {
    AirQualityHeadlineCard(
        color = dark_DangerDarkerColor,
        textColor = dark_onDangerDarkerColor,
        qualityIndex = 160,
        qualityStatus = "Unhealthy",
        qualityDesc = "Increase likelihood of adverse effects.\n" +
            "Aggravation to the heart and lunge among\n" +
            "general public."
    )
}