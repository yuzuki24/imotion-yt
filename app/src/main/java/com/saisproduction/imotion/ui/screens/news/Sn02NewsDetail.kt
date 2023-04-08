package com.saisproduction.imotion.ui.screens.news

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.saisproduction.imotion.R
import com.saisproduction.imotion.data.NewsRepo
import java.time.format.DateTimeFormatter

@Composable
fun Sn02NewsDetail(
    newsId: Int,
    modifier: Modifier = Modifier,
) {
    val news = NewsRepo.getNews().first { news -> news.newsId == newsId }
    Column(
        modifier = Modifier.padding(12.dp),
        verticalArrangement = Arrangement.Top,
    ) {
        Text(
            text = news.title,
            style = MaterialTheme.typography.titleMedium,
        )
        Spacer(Modifier.height(6.dp))
        Text(
            text = news.date.format(DateTimeFormatter.ofPattern(stringResource(R.string.article_date_format))),
            style = MaterialTheme.typography.labelMedium,
            color = Color.Gray,
        )
        Spacer(Modifier.height(10.dp))
        Divider(thickness = 1.dp, color = Color.Black)
        Spacer(Modifier.height(12.dp))
        Text(
            text = news.article ?: "",
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NewsDetailPreview() {
    Sn02NewsDetail(1)
}