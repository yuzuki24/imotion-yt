package com.saisproduction.imotion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.saisproduction.imotion.ui.components.C001ImnTopBar
import com.saisproduction.imotion.ui.components.C002ImnBottomBar
import com.saisproduction.imotion.ui.screens.news.Sn01NewsList
import com.saisproduction.imotion.ui.screens.news.Sn02NewsDetail
import com.saisproduction.imotion.ui.theme.ImotionTheme

@ExperimentalMaterial3Api
class ImnActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImnApp()
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun ImnApp() {
    ImotionTheme {
        val navController = rememberNavController()

        val currentBackStack by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStack?.destination
        val currentScreen = Destinations.find {
            it.route == currentDestination?.route?.substringBefore('/')
        } ?: Top

        Scaffold(
            topBar = {
                C001ImnTopBar(
                    title = currentScreen.title,
                    isVisibleBackButton = currentScreen.isVisibleBackButton,
                    onBackButtonClicked = { navController.popBackStack() },
                    modifier = Modifier,
                )
            },
            bottomBar = {
                C002ImnBottomBar(
                    currentDestination = currentScreen,
                    onItemSelected = { newScreen ->
                        if (newScreen.route != currentScreen.route) {
                            navController.navigate(newScreen.route)
                        }
                    },
                    modifier = Modifier,
                )
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = SettingTop.route,
                modifier = Modifier.padding(innerPadding),
            ) {
                composable(SettingTop.route) {navBackStackEntry ->
                    SettingTop(
                        onNavigation = { unitId ->
                            navController.navigateSingleTopTo("${Top.route}/$unitId") }
                    )
                }


                composable("${Top.route}/{unitId}") {navBackStackEntry ->
                    val unitId = navBackStackEntry.arguments?.getString("unitId")
                    Top(
                        unitId = unitId ?: "",
                        onNavigation = { navController.navigateSingleTopTo("${MemberList.route}/$unitId") },
                        onNewsSelected = { newsId ->
                            navController.navigateSingleTopTo("${NewsDetail.route}/$newsId")
                        },
                        onNewsListSelected={navController.navigateSingleTopTo("${NewsList.route}")}

                    )
                }
                composable("${MemberList.route}/{unitId}") {
                        navBackStackEntry ->
                    val unitId = navBackStackEntry.arguments?.getString("unitId")
                    Member(
                        unitId = unitId ?: ""
                    ) { memberId ->
                        navController.navigateSingleTopTo("${Individual.route}/$memberId")
                    }
                }
                composable(
                    route = Individual.routeWithArgs,
                    arguments = Individual.arguments,
                ) {
                        navBackStackEntry ->
                    val memberId = navBackStackEntry.arguments?.getInt(Individual.memberIdArg) ?: 0
                    Individual(memberId)
                }
                composable(NewsList.route) {
                    Sn01NewsList(
                        onNewsSelected = { newsId ->
                            navController.navigateSingleTopTo("${NewsDetail.route}/$newsId")
                        }
                    )
                }
                composable(
                    route = NewsDetail.routeWithArgs,
                    arguments = NewsDetail.arguments,
                ) {
                    navBackStackEntry ->
                    val newsId = navBackStackEntry.arguments?.getInt(NewsDetail.newsIdArg) ?: 1
                    Sn02NewsDetail(newsId)
                }
            }
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        launchSingleTop = true
        //遷移前のスクロール状態などは保持しない
        restoreState = false
    }

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun AppPreview() {
    ImotionTheme {
        ImnApp()
    }
}