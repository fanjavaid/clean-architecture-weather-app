package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fanjavaid.clean_architecture_flat_weather_app.R
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.city.City
import com.fanjavaid.clean_architecture_flat_weather_app.ui.theme.WeatherAppTheme

private val searchResultShape = RoundedCornerShape(28.dp).copy(
    topStart = CornerSize(0.dp),
    topEnd = CornerSize(0.dp),
)

@Composable
fun WeatherCitySearch(
    modifier: Modifier = Modifier,
    cityName: String,
    results: List<City>?,
    loading: Boolean,
    onValueChange: (String) -> Unit,
    onSearch: (String) -> Unit,
    onSelect: (City) -> Unit
) {
    Column(modifier = modifier.fillMaxWidth()) {
        WeatherCitySearchField(
            loading = loading,
            cityName = cityName,
            showResults = results != null,
            onValueChange = onValueChange,
            onSearch = onSearch
        )
        AnimatedVisibility(visible = results != null) {
            if (!results.isNullOrEmpty()) {
                Divider()
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(max = 200.dp)
                        .background(
                            MaterialTheme.colorScheme.background,
                            searchResultShape
                        )
                        .animateContentSize()
                ) {
                    items(results) { item ->
                        WeatherCitySearchListItem(
                            modifier = Modifier.clickable {
                                onSelect(item)
                            },
                            title = item.cityName
                        )
                    }
                }
            } else if (results?.isEmpty() == true) {
                Divider()
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            MaterialTheme.colorScheme.background,
                            searchResultShape
                        )
                        .animateContentSize()
                ) {
                    WeatherCitySearchListItem(title = "No results.")
                }
            }
        }
    }
}

@Composable
fun WeatherCitySearchListItem(
    modifier: Modifier = Modifier,
    title: String
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            modifier = Modifier.padding(start = 50.dp, end = 16.dp),
            text = title,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherCitySearchField(
    modifier: Modifier = Modifier,
    cityName: String,
    showResults: Boolean = false,
    loading: Boolean = false,
    onValueChange: (String) -> Unit,
    onSearch: (String) -> Unit,
) {
    Row(
        modifier = modifier
            .background(
                MaterialTheme.colorScheme.background,
                if (showResults) {
                    CircleShape.copy(
                        bottomStart = CornerSize(0.dp),
                        bottomEnd = CornerSize(0.dp)
                    )
                } else CircleShape
            )
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            modifier = Modifier
                .weight(1f)
                .height(56.dp),
            value = cityName,
            onValueChange = onValueChange,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearch(cityName)
                }
            ),
            placeholder = {
                Text(text = "Search city")
            },
            leadingIcon = {
                Icon(Icons.Default.Search, null)
            },
            trailingIcon = {
                AnimatedVisibility(loading) {
                    CircularProgressIndicator(
                        Modifier.size(18.dp),
                        color = MaterialTheme.colorScheme.onBackground,
                        strokeWidth = 2.dp,
                    )
                }
            },
            textStyle = MaterialTheme.typography.bodyLarge,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
            )
        )
        Spacer(modifier = Modifier.width(16.dp))
        WeatherUserAvatar(
            modifier = Modifier.padding(end = 16.dp),
            size = 32.dp,
            image = R.drawable.img_avatar_sample,
            description = ""
        )
    }
}

@Preview
@Composable
fun WeatherCitySearchFieldPreview() {
    WeatherCitySearchField(
        cityName = "Banyuwangi",
        showResults = false,
        onValueChange = {},
        onSearch = {}
    )
}

@Preview
@Composable
fun WeatherCitySearchPreview() {
    Column {
        WeatherAppTheme {
            WeatherCitySearch(
                cityName = "",
                results = listOf(),
                loading = false,
                onValueChange = {},
                onSearch = {},
                onSelect = {}
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        WeatherAppTheme {
            WeatherCitySearch(
                cityName = "",
                results = listOf(
                    City("", "Jakarta"),
                    City("", "Surabaya"),
                    City("", "Bandung")
                ),
                loading = false,
                onValueChange = {},
                onSearch = {},
                onSelect = {}
            )
        }
    }
}