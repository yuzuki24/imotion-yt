package com.saisproduction.imotion.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.saisproduction.imotion.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun C001ImnTopBar(
    title: String = "Unknown Screen",
    isVisibleBackButton: Boolean = false,
    onBackButtonClicked: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        // TODO: 戻るボタンは消す
        navigationIcon = {
            if (isVisibleBackButton) {
                IconButton(onClick = onBackButtonClicked) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "前の画面に戻る"
                    )
                }
            }
        },
        actions = {
            IconButton(onClick = { expanded = true }) {
                Icon(
                    Icons.Default.MoreVert,
                    contentDescription = "ユーザー設定"
                )
            }
            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                DropdownMenuItem(
                    // FIXME: DB値に応じて変更
                    text = { Text(text = "このユニットをホーム画面に固定する") },
                    onClick = { changeFavorite() }
                )
                DropdownMenuItem(
                    text = { Text(text = stringResource(R.string.option_back_to_st002)) },
                    onClick = { backToSt002() }
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(),
        modifier = modifier,
    )
}

/**
 * ホーム画面固定ユニット 変更.
 */
private fun changeFavorite() {
    // TODO:
}

/**
 * ユニット選択画面へ戻る.
 */
private fun backToSt002() {
    // TODO:
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    C001ImnTopBar()
}