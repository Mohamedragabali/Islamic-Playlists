package com.muslim.islamicplaylists.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun HomeScreen(
    viewModel: HomeViewModel= hiltViewModel(),
    navController: NavController,
    modifier: Modifier = Modifier
){
    val state by viewModel.state.collectAsState()
    HomeScreenContent(
        state,
        modifier = modifier
    )
}

@Composable
private fun HomeScreenContent(
    state:String ,
    modifier: Modifier
){
    Column (
        modifier = modifier.fillMaxSize().verticalScroll(
            rememberScrollState()
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = state,
        )
    }
}