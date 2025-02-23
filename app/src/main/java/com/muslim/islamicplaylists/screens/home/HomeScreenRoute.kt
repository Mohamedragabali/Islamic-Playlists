package com.muslim.islamicplaylists.screens.home

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.muslim.islamicplaylists.utils.AppDestination

fun NavGraphBuilder.homeScreenRoute(
    navController: NavController,
    modifier: Modifier
) {
    composable(AppDestination.HOME){
        HomeScreen(
            navController = navController,
            modifier = modifier
        )
    }
}