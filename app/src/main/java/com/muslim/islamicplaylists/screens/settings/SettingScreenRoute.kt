package com.muslim.islamicplaylists.screens.settings

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.muslim.islamicplaylists.utils.AppDestination

fun NavGraphBuilder.settingScreenRoute(
    navController: NavController,
    modifier: Modifier
) {
    composable(AppDestination.SETTING){
        SettingScreen(
            navController = navController,
            modifier = modifier
        )
    }
}