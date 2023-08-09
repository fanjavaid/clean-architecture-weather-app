package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.fanjavaid.clean_architecture_flat_weather_app.R
import com.fanjavaid.clean_architecture_flat_weather_app.ui.theme.WeatherAppTheme

@Composable
fun WeatherTextIconVertical(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    iconSize: Dp = 20.dp,
    text: String
) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(iconSize),
            painter = painterResource(id = icon),
            contentDescription = null,
            colorFilter = ColorFilter.tint(
                color = MaterialTheme.colorScheme.onPrimary
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium.copy(
                color = MaterialTheme.colorScheme.onPrimary,
                fontWeight = FontWeight.Light
            )
        )
    }
}

@Preview(showBackground = false)
@Composable
fun WeatherTextIconVerticalPreview() {
    WeatherAppTheme {
        WeatherTextIconVertical(
            icon = R.drawable.ic_humidity,
            text = "69%"
        )
    }
}
