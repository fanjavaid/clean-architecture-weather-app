package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.presentation.air_quality.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.air_quality.AirQualityComponent

@Composable
fun AirQualityComponentList(
    modifier: Modifier = Modifier,
    components: List<AirQualityComponent>
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(components) { component ->
            AirQualityComponent(
                title = component.name,
                desc = component.desc,
                value = component.value,
            )
        }
    }
}

@Composable
fun AirQualityComponent(
    modifier: Modifier = Modifier,
    title: String,
    desc: String,
    value: Double
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                MaterialTheme.colorScheme.surface,
                MaterialTheme.shapes.medium
            )
            .padding(16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                modifier = Modifier.alignByBaseline(),
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                modifier = Modifier.alignByBaseline(),
                text = desc,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
        Text(
            text = value.toString(),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Preview
@Composable
fun AirQualityComponentListPreview() {
    AirQualityComponentList(
        components = listOf(
            AirQualityComponent("CO", "Carbon monixide", 1340.56)
        )
    )
}

@Preview
@Composable
fun AirQualityComponentPreview() {
    AirQualityComponent("CO", "Carbon monixide", 1340.56)
}