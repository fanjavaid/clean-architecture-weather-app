package com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.presentation

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.presentation.components.AirQualityHeadlineCard
import com.fanjavaid.clean_architecture_flat_weather_app.feature_aiq.presentation.util.getQualityIndexInformation

@Composable
fun AirQualityScreen(
    modifier: Modifier = Modifier,
    viewModel: AirQualityViewModel = hiltViewModel()
) {
    val airQualityState by viewModel.airQualityIndexState.collectAsState()
    val airQualityIndex = airQualityState.data?.index ?: 0
    val additionalInfo = getQualityIndexInformation(
        airQualityIndex,
        isSystemInDarkTheme()
    )

    LazyVerticalGrid(
        modifier = modifier.fillMaxSize(),
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        item(span = { GridItemSpan(2) }) {
            AirQualityHeadlineCard(
                color = additionalInfo.color,
                textColor = additionalInfo.textColor,
                qualityIndex = airQualityIndex,
                qualityStatus = additionalInfo.title,
                qualityDesc = additionalInfo.description
            )
        }
    }
}

@Preview
@Composable
fun AirQualityScreenPreview() {
    AirQualityScreen()
}