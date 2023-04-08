package com.saisproduction.imotion

import android.annotation.SuppressLint
import android.util.TypedValue
import android.view.MotionEvent
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saisproduction.imotion.data.NewsRepo
import com.saisproduction.imotion.ui.screens.news.Sn01NewsList
import com.saisproduction.imotion.ui.screens.news.Sn02NewsDetail
import java.time.format.DateTimeFormatter
import androidx.compose.ui.viewinterop.AndroidView
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.*

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.graphics.toArgb


@SuppressLint("SetJavaScriptEnabled")
@Composable
fun YoutubePlayer(videoId: String) {
    AndroidView(
        factory = { context ->
            val webView = WebView(context)
            //webView.setBackgroundColor(Color.Transparent.toArgb()) // 背景を透明に設定する
            webView.settings.javaScriptEnabled = true
            webView.settings.cacheMode = WebSettings.LOAD_NO_CACHE // キャッシュを無効にする
            webView.webChromeClient = WebChromeClient() // WebChromeClientを設定する
            webView.webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    view?.loadUrl("javascript:(function() { " +
                            "var player = document.querySelector('.html5-video-player');" +
                            "player.playVideo();" +
                            "})()")
                }
            }
            webView.loadUrl("https://www.youtube.com/@earthacesnd2223")
            val heightInDp = 500
            val heightInPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, heightInDp.toFloat(), context.resources.displayMetrics).toInt()
            val layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, heightInPx)
            webView.layoutParams = layoutParams
            webView.setOnTouchListener { _, event ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        webView.parent.requestDisallowInterceptTouchEvent(true)
                    }
                    MotionEvent.ACTION_UP -> {
                        webView.parent.requestDisallowInterceptTouchEvent(false)
                    }
                }
                false
            }
            webView
        },
        update = { webView ->
            webView.loadUrl("https://www.youtube.com/@earthacesnd2223")
        }
    )
}



@Composable
fun Top(unitId: String, onNavigation: () -> Unit,onNewsSelected: (Int) -> Unit = {},
        onNewsListSelected: () -> Unit = {}) {
    val units = AllUnit.getUNITS().toList().firstOrNull { it.UNIT_ID == unitId.toIntOrNull() }
    val newsList = NewsRepo.getNews()
    Column {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally, // 横方向
            verticalArrangement = Arrangement.Center // 縦方向


        ) {
            units?.let {
                item {
                    //ユニット名
                    Text(
                        text = units.UNIT_NAME, color = Color(0xFFD0BCFF), fontSize = 60.sp,

                        )
                    //ユニット画像
                    Image(
                        painter = painterResource(id = R.drawable.earthace),
                        contentDescription = "",
                        modifier = Modifier
                            .size(width = 1000.dp, height = 300.dp)
                            .padding(start = 0.dp)
                    )

                }
            }
            item {

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween

                ) {
                    //各画面へユニットの情報を表示
                    val handler = LocalUriHandler.current
                    Button(
                        colors = ButtonDefaults.textButtonColors(
                            containerColor = Color.LightGray,
                            contentColor = Color(0xFFFF8C00),
                            disabledContentColor = Color.LightGray
                        ),
                        onClick = { handler.openUri("http://saisproduction.com/belong/") },
                        shape = RectangleShape,
                        modifier = Modifier
                            .size(width = 200.dp, height = 80.dp)
                            .padding(top = 20.dp, start = 20.dp)
                    ) {
                        Text(text = "ユニット紹介へ", fontWeight = FontWeight.Bold)
                    }
                    Button(
                        colors = ButtonDefaults.textButtonColors(
                            containerColor = Color.LightGray,
                            contentColor = Color(0xFFFF8C00),
                            disabledContentColor = Color.LightGray
                        ),
                        onClick = { onNavigation() },
                        shape = RectangleShape,
                        modifier = Modifier
                            .size(width = 200.dp, height = 80.dp)
                            .padding(top = 20.dp, start = 20.dp)
                    ) {
                        Text(text = "メンバー紹介へ", fontWeight = FontWeight.Bold)
                    }

                }
            }
            item {
                //youtube

                YoutubePlayer(videoId = "uN2FucNynCM")
                //twitter

            }
            item {
                //ユニットのお知らせを表示する
                Column(
                    modifier = Modifier
                        //.height(60.dp)
                        .fillMaxWidth()
                        .padding(10.dp)
                        .border(
                            width = 5.dp,
                            color = Color.White,
                            shape = RectangleShape
                        )
                        .background(
                            color = Color.Transparent,
                            shape = RectangleShape
                        ),
                ) {

                    Button(
                        colors = ButtonDefaults.textButtonColors(
                            containerColor = Color.LightGray,
                            contentColor = Color(0xFFFF8C00),
                            disabledContentColor = Color.LightGray
                        ),
                        onClick = { onNewsListSelected() },
                        shape = RectangleShape,
                        modifier = Modifier
                            .padding(start = 2.dp, top = 10.dp)
                            .align(Alignment.Start),
                    ) {
                        Text(
                            text = "お知らせ一覧",
                            modifier = Modifier
                                .size(width = 150.dp, height = 20.dp)
                            //.padding(start = 0.dp,top = 20.dp)
                        )

                    }

                }
            }

            item {
                if (newsList.isNotEmpty()) {
                    val selectedNews = remember { mutableStateOf(newsList[0]) }

                    Column(
                        Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp, horizontal = 16.dp)
                    ) {
                        for (news in newsList.take(3)) {
                            val isSelected = remember { news.newsId == selectedNews.value.newsId }
                            val backgroundColor =
                                if (isSelected) Color.LightGray else Color.Transparent
                            Column(
                                Modifier
                                    .clickable {
                                        onNewsSelected(news.newsId)
                                    }
                            ) {
                                Text(
                                    text = news.title,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    style = MaterialTheme.typography.bodyMedium,
                                    modifier = Modifier.padding(12.dp),
                                )
                                Text(
                                    style = MaterialTheme.typography.labelSmall,
                                    text = news.date.format(DateTimeFormatter.ofPattern(
                                        stringResource(R.string.article_date_format))),
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    modifier = Modifier.padding(start = 8.dp,
                                        top = 2.dp,
                                        end = 8.dp,
                                        bottom = 6.dp)
                                )
                                Divider(thickness = 1.dp, color = Color.Black)
                            }
                        }
                    }
                }
            }
        }


    }

}





