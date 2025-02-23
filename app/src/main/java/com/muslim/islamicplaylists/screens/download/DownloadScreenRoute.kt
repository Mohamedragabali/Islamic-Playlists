package com.muslim.islamicplaylists.screens.download

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.muslim.islamicplaylists.utils.AppDestination

fun NavGraphBuilder.downloadScreenRout(
    navController: NavController,
    modifier: Modifier
) {
    composable(AppDestination.DOWNLOAD){
        DownLoadScreen(
            navController = navController,
            modifier = modifier
        )
    }
}