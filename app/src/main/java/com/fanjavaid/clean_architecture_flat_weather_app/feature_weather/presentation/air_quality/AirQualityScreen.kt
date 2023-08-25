package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.presentation.air_quality

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.presentation.air_quality.components.AirQualityComponentList
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.presentation.air_quality.components.AirQualityHeadlineCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AirQualityScreen(
    modifier: Modifier = Modifier,
    viewModel: AirQualityViewModel = hiltViewModel()
) {
    val airQualityState by viewModel.airQualityIndexState.collectAsState()

    LaunchedEffect(true) {
        viewModel.getAirQualityIndex()
    }

    Scaffold(
        modifier = modifier
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AirQualityHeadlineCard(
                qualityIndex = airQualityState.data?.qualityIndex ?: 0.0,
                qualityStatus = "Dummy",
                qualityDesc = "Increase likelihood of adverse effects.\n" +
                    "Aggravation to the heart and lunge among\n" +
                    "general public."
            )
            AirQualityComponentList(
                components = airQualityState.data?.components.orEmpty()
            )
        }
    }
}

@Preview
@Composable
fun AirQualityScreenPreview() {
    AirQualityScreen()
}