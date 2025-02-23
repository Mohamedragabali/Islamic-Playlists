package com.muslim.islamicplaylists.screens.favorite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun FavoriteScreen(
    navController : NavController,
    modifier :Modifier = Modifier
){
    FavoriteScreenContent(
        modifier = modifier
    )
}

@Composable
private fun FavoriteScreenContent(
    modifier: Modifier
){
    Column (
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "FavoriteScreen"
        )
    }

}