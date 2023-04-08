package com.saisproduction.imotion.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.material3.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.saisproduction.imotion.*

@Composable
fun C002ImnBottomBar(
    currentDestination: ImnDestination,
    onItemSelected: (ImnDestination) -> Unit,
    modifier: Modifier = Modifier
) {
    val isVisible = DestinationsInBottomBar.any { it.route == currentDestination.route }
    if (!isVisible) {
        return
    }
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background,
        modifier = modifier,
    ) {
        // FIXME: forEach処理できるように修正
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null,
                )
            },
            label = { Text(text = stringResource(com.saisproduction.imotion.R.string.bottom_nav_top)) },
            selected = currentDestination.route == Top.route,
            onClick = { onItemSelected(Top) }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                )
            },
            label = { Text(text = stringResource(com.saisproduction.imotion.R.string.bottom_nav_members)) },
            selected = currentDestination.route == MemberList.route,
            onClick = { onItemSelected(MemberList) }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.List,
                    contentDescription = null,
                )
            },
            label = { Text(text = stringResource(com.saisproduction.imotion.R.string.bottom_nav_news)) },
            selected = currentDestination.route == NewsList.route,
            onClick = { onItemSelected(NewsList) }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BottomBarPreview() {
    C002ImnBottomBar(
        currentDestination = Top,
        onItemSelected = {}
    )
}