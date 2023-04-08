package com.saisproduction.imotion.data

import java.time.LocalDateTime

/**
 * お知らせ データクラス.
 */
data class News(
    val newsId: Int,
    val date: LocalDateTime,
    val title: String,
    val article: String? = null,
)

/**
 * お知らせデータリポジトリ.
 */
object NewsRepo {
    // FIXME: 現時点ではテストデータを表示するだけ
    fun getNews(): List<News> = news
}

// --- テスト用データ ---

private val sample1 = News(
    newsId = 1,
    date = LocalDateTime.now(),
    title = "タイトル1",
    article = """
        記事1
        このお知らせはサンプルです。
        
        このお知らせはサンプルです。
        
    """.trimIndent(),
)
private val sample2 = News(
    newsId = 2,
    date = LocalDateTime.now(),
    title = "タイトル2",
    article = "記事2",
)
private val sample3 = News(
    newsId = 3,
    date = LocalDateTime.now(),
    title = "タイトル3",
    article = "記事3",
)

private val news = listOf(
    sample1, sample2, sample3, sample1, sample2
)