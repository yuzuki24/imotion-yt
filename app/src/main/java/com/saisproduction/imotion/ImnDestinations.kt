package com.saisproduction.imotion

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavType
import androidx.navigation.navArgument


interface ImnDestination {
    val icon: ImageVector
    val route: String
    val title: String
    val isVisibleBackButton: Boolean
}

object SettingTop : ImnDestination {
    override val icon = Icons.Filled.Home
    override val route = "setting_top"
    override val title = ""
    override val isVisibleBackButton = false
}

object Top : ImnDestination {
    override val icon = Icons.Filled.Home
    override val route = "top/{unitId}"
    override val title = ""
    override val isVisibleBackButton = false
}

object NewsList : ImnDestination {
    override val icon = Icons.Filled.List
    override val route = "news_list"
    override val title = "お知らせ"
    override val isVisibleBackButton = false
}

object MemberList : ImnDestination {
    // FIXME:
    override val icon = Icons.Filled.Person
    override val route = "member_list"
    override val title = "メンバー"
    override val isVisibleBackButton = false
}

object Individual : ImnDestination {
    override val icon = Icons.Filled.List
    override val route = "individual"
    const val memberIdArg = "member_id"
    override val title = "お知らせ"
    override val isVisibleBackButton = true
    val routeWithArgs = "$route/{$memberIdArg}"
    val arguments = listOf(
        navArgument(memberIdArg) { type = NavType.IntType }
    )
}

object NewsDetail : ImnDestination {
    override val icon = Icons.Filled.List
    override val route = "news_detail"
    const val newsIdArg = "news_id"
    override val title = "お知らせ"
    override val isVisibleBackButton = true
    val routeWithArgs = "$route/{$newsIdArg}"
    val arguments = listOf(
        navArgument(newsIdArg) { type = NavType.IntType }
    )
}

val Destinations = listOf(Top, MemberList, Individual, NewsList, NewsDetail)
val DestinationsInBottomBar = listOf(Top, MemberList, NewsList)