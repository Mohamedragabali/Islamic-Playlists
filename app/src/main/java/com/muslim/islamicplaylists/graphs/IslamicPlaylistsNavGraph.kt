package com.muslim.islamicplaylists.graphs

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.muslim.islamicplaylists.screens.download.downloadScreenRout
import com.muslim.islamicplaylists.screens.everynew.everyNewScreenRoute
import com.muslim.islamicplaylists.screens.favorite.favoriteScreenRoute
import com.muslim.islamicplaylists.screens.home.homeScreenRoute
import com.muslim.islamicplaylists.screens.settings.settingScreenRoute
import com.muslim.islamicplaylists.utils.AppDestination

@Composable
fun IslamicPlaylistsNavGraph(
    navController: NavHostController,
    modifier: Modifier
){
    NavHost(
        navController = navController,
         startDestination = AppDestination.HOME
    ){
       homeScreenRoute(
           navController = navController,
           modifier = modifier
       )
        everyNewScreenRoute(
            navController = navController,
            modifier = modifier
        )
        favoriteScreenRoute(
            navController=navController,
            modifier = modifier
        )
        downloadScreenRout(
            navController=navController,
            modifier=modifier
        )
        settingScreenRoute(
            navController=navController,
            modifier=modifier
        )
    }
}