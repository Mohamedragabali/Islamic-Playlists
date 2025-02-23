package com.muslim.islamicplaylists.screens.everynew

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.muslim.islamicplaylists.utils.AppDestination


fun NavGraphBuilder.everyNewScreenRoute(
    navController: NavController,
    modifier: Modifier
) {
    composable(AppDestination.EVERY_NEW){
        EveryNewScreen(
            navController = navController,
            modifier = modifier
        )
    }
}