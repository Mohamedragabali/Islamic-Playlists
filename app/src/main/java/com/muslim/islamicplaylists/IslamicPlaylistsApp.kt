package com.muslim.islamicplaylists

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.muslim.islamicplaylists.composable.CustomNavigationBar
import com.muslim.islamicplaylists.composable.Greeting
import com.muslim.islamicplaylists.ui.theme.IslamicPlaylistsTheme

@Composable
fun IslamicPlaylistsApp(){
    var state by rememberSaveable { mutableStateOf(AppDestination.HOME) }
    IslamicPlaylistsTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                CustomNavigationBar(state) { selectedItem->
                    state = selectedItem
                }
            }
        ) { innerPadding ->
            Greeting(
                name = "Android",
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

