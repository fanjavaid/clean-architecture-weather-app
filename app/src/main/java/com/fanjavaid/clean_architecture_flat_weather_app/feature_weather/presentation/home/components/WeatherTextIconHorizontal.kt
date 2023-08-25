package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.presentation.home.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fanjavaid.clean_architecture_flat_weather_app.R
import com.fanjavaid.clean_architecture_flat_weather_app.ui.theme.WeatherAppTheme

@Composable
fun WeatherTextIconHorizontal(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    text: String
) {

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.size(20.dp),
            painter = painterResource(id = icon),
            contentDescription = null,
            colorFilter = ColorFilter.tint(
                color = MaterialTheme.colorScheme.onPrimary
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
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
fun WeatherTextIconHorizontal() {
    WeatherAppTheme {
        WeatherTextIconHorizontal(
            icon = R.drawable.ic_humidity,
            text = "69%"
        )
    }
}
