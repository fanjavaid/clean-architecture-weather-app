package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.city.City
import com.fanjavaid.clean_architecture_flat_weather_app.ui.theme.WeatherAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherCitySearch(
    modifier: Modifier = Modifier,
    cityName: String,
    loading: Boolean = false,
    results: List<City>?,
    onValueChange: (String) -> Unit,
    onSearch: (String) -> Unit,
    onSelect: (City) -> Unit
) {
    Card(
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(
                value = cityName,
                onValueChange = onValueChange,
                placeholder = {
                    Text(text = "Enter city name")
                },
                leadingIcon = {
                    Icon(Icons.Default.Search, null)
                },
                trailingIcon = {
                    AnimatedVisibility(loading) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(24.dp).alpha(.7f),
                            color = MaterialTheme.colorScheme.onPrimary,
                            strokeWidth = 2.dp
                        )
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                ),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        onSearch(cityName)
                    }
                )
            )

            if (!results.isNullOrEmpty()) {
                LazyColumn(
                    modifier = Modifier.animateContentSize(),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(
                        top = 0.dp,
                        start = 50.dp,
                        bottom = 16.dp,
                        end = 16.dp
                    )
                ) {
                    items(results) { item ->
                        Text(
                            modifier = Modifier.clickable {
                                onSelect(item)
                            },
                            text = item.cityName,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            } else if (results?.isEmpty() == true) {
                Box(
                    modifier = Modifier.padding(
                        top = 0.dp,
                        start = 50.dp,
                        bottom = 16.dp,
                        end = 16.dp
                    ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "No results.",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun WeatherCitySearchPreview() {
    WeatherAppTheme {
        WeatherCitySearch(
            cityName = "",
            results = listOf(),
            onValueChange = {},
            onSearch = {},
            onSelect = {}
        )
    }
}