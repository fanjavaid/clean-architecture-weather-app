package com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.fanjavaid.clean_architecture_flat_weather_app.R
import com.fanjavaid.clean_architecture_flat_weather_app.feature_weather.domain.models.news.News
import java.util.Date

@Composable
fun WeatherNewsList(
    modifier: Modifier = Modifier,
    newsList: List<News>,
    onClickItem: (String) -> Unit
) {
    Column(modifier = modifier) {
        Text(text = "News & Updates", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))
        newsList.forEach { news ->
            WeatherNewsListItem(news = news, onClick = onClickItem)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun WeatherNewsListItem(
    modifier: Modifier = Modifier,
    news: News,
    onClick: (String) -> Unit
) {
    val view = LocalView.current

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                MaterialTheme.colorScheme.background,
                MaterialTheme.shapes.medium
            )
            .clickable {
                onClick(news.webUrl)
            }
            .padding(24.dp)
    ) {
        if (!view.isInEditMode) {
            AsyncImage(
                modifier = Modifier.size(64.dp).clip(MaterialTheme.shapes.small),
                contentScale = ContentScale.Crop,
                model = news.thumbnail,
                contentDescription = null
            )
        } else {
            Image(
                modifier = Modifier.size(64.dp),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.img_weather_bg),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = news.by.uppercase(),
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = .8f)
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = news.headline,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = news.trailText,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = .9f),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview
@Composable
fun WeatherNewsListItemPreview() {
    WeatherNewsListItem(
        news = News(
            id = "1",
            webUrl = "",
            headline = "Wet and cold weather brings snow to Australia’s Alps",
            trailText = "Winter has set in and forecasters predict clear frosty nights and chilly icy mornings for south-east",
            thumbnail = "",
            lastUpdate = Date(),
            by = "Natasha May",
            body = ""
        ),
        onClick = {}
    )
}

@Preview(heightDp = 350)
@Composable
fun WeatherNewsListPreview() {
    WeatherNewsList(newsList = List(5) {
        News(
            id = "$it",
            webUrl = "",
            headline = "Wet and cold weather brings snow to Australia’s Alps",
            trailText = "Winter has set in and forecasters predict clear frosty nights and chilly icy mornings for south-east",
            thumbnail = "",
            lastUpdate = Date(),
            by = "Natasha May",
            body = ""
        )
    }) {}
}