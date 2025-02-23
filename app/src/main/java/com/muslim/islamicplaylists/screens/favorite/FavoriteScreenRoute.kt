package com.muslim.islamicplaylists.screens.favorite

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.muslim.islamicplaylists.utils.AppDestination


fun NavGraphBuilder.favoriteScreenRoute(
    navController: NavController,
    modifier: Modifier
) {
    composable(AppDestination.FAVORITE){
        FavoriteScreen(
            navController = navController,
            modifier = modifier
        )
    }
}