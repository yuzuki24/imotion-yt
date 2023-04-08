package com.saisproduction.imotion.ui.screens.top

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun St01Top(
    onClick: () -> Unit
) {
    Button(
        onClick = onClick
    ) {
        Text(text = "サンプルボタン　お知らせ一覧表示")
    }
}

@Preview
@Composable
fun TopPreview() {
    St01Top({})
}