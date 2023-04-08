package com.saisproduction.imotion.ui.screens.news

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.saisproduction.imotion.R
import com.saisproduction.imotion.data.News
import com.saisproduction.imotion.data.NewsRepo
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun Sn01NewsList(
    onNewsSelected: (Int) -> Unit = {},
    modifier: Modifier = Modifier,
) {
    val newsList = NewsRepo.getNews()
    LazyColumn(
        modifier = Modifier.padding(6.dp)
    ) {
        items(items = newsList) { news ->
            NewsCard(
                news = news,
                onNewsSelected = onNewsSelected,
            )
        }
    }
}

@Composable
private fun NewsCard(
    news: News,
    onNewsSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    // TODO: Cardではない方が良い気もする
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
            onNewsSelected(news.newsId)
        }.padding(4.dp),
    ) {
        Text(
            style = MaterialTheme.typography.titleMedium,
            text = news.title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(start = 6.dp, top = 6.dp, end = 6.dp)
        )
        Text(
            style = MaterialTheme.typography.labelSmall,
            text = news.date.format(DateTimeFormatter.ofPattern(stringResource(R.string.article_date_format))),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(start = 8.dp, top = 2.dp, end = 8.dp, bottom = 6.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NewsListPreview() {
    Sn01NewsList()
}