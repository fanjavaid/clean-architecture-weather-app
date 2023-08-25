package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.presentation.home.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.fanjavaid.clean_architecture_flat_weather_app.R

@Composable
fun WeatherUserAvatar(
    modifier: Modifier = Modifier,
    size: Dp,
    @DrawableRes image: Int,
    description: String,
    onClick: () -> Unit = {}
) {
    Image(
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .clickable { onClick() },
        painter = painterResource(id = image),
        contentDescription = description
    )
}

@Preview
@Composable
fun WeatherUserAvatarPreview() {
    Row {
        WeatherUserAvatar(
            size = 24.dp,
            image = R.drawable.img_avatar_sample,
            description = "Avatar",
            onClick = {}
        )
        Spacer(modifier = Modifier.width(8.dp))
        WeatherUserAvatar(
            size = 32.dp,
            image = R.drawable.img_avatar_sample,
            description = "Avatar",
            onClick = {}
        )
        Spacer(modifier = Modifier.width(8.dp))
        WeatherUserAvatar(
            size = 40.dp,
            image = R.drawable.img_avatar_sample,
            description = "Avatar",
            onClick = {}
        )
        Spacer(modifier = Modifier.width(8.dp))
        WeatherUserAvatar(
            size = 48.dp,
            image = R.drawable.img_avatar_sample,
            description = "Avatar",
            onClick = {}
        )
    }
}