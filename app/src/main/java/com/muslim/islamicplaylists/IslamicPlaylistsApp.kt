package com.muslim.islamicplaylists

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import com.muslim.islamicplaylists.composable.CustomNavigationBar
import com.muslim.islamicplaylists.graphs.IslamicPlaylistsNavGraph
import com.muslim.islamicplaylists.ui.theme.IslamicPlaylistsTheme
import com.muslim.islamicplaylists.utils.AppDestination

@Composable
fun IslamicPlaylistsApp(){
    var state by rememberSaveable { mutableStateOf(AppDestination.HOME) }
    val navController = rememberNavController()
    IslamicPlaylistsTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                CustomNavigationBar(state) { selectedItem->
                    state = selectedItem
                    navController.navigate(state) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                }
            }
        ) { innerPadding ->
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl){
                IslamicPlaylistsNavGraph(
                    navController = navController,
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}

