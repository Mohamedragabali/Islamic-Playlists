package com.muslim.islamicplaylists

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.muslim.islamicplaylists.composable.Greeting
import com.muslim.islamicplaylists.ui.theme.IslamicPlaylistsTheme

@Composable
fun IslamicPlaylistApp(){
    IslamicPlaylistsTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            Greeting(
                name = "Android",
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}