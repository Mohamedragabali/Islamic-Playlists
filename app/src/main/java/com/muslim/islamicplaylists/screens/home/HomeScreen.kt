package com.muslim.islamicplaylists.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import com.muslim.islamicplaylists.R
import com.muslim.islamicplaylists.screens.detials.navigateToVideoDetailScreen

@Composable
fun HomeScreen(
    viewModel: HomeViewModel= hiltViewModel(),
    navController: NavController,
    modifier: Modifier = Modifier
){
    val state by viewModel.state.collectAsState()
    HomeScreenContent(
        state,
        modifier = modifier,
        onClickItem = {sectionName, playlistName,  videoId , videoTitle ->
            navController.navigateToVideoDetailScreen(
                sectionName=sectionName,
                playlistName = playlistName,
                videoId = videoId,
                videoTitle = videoTitle
            )
        }

    )
}
@Composable
private fun HomeScreenContent(
    state:HomeUIState ,
    modifier: Modifier,
    onClickItem:(
        sectionName:String,
        playlistName:String ,
        videoId:String ,
        videoTitle : String,
    )->Unit
){
    when(state){
        is HomeUIState.Data -> DataContent(
            state,
            modifier,
            onClickItem
        )
        is HomeUIState.Error -> ErrorContent()
        HomeUIState.Loading -> LoadingContent()
    }
}

@Composable
private fun LoadingContent(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
private fun ErrorContent(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center

    ) {
        Text("please check your internet")
    }
}

@Composable
private fun DataContent(
    state:HomeUIState.Data ,
    modifier: Modifier,
    onClickItem:(
        sectionName:String,
        playlistName:String ,
        videoId:String ,
        videoTitle : String,
    )->Unit
){
    LazyColumn(
        modifier = modifier.fillMaxSize(),
    ) {
        item {
            Box(modifier = Modifier.padding(16.dp)){
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Column {
                        Text(
                            text = stringResource(R.string.hallo_again)
                        )
                    }
                    Spacer(Modifier.weight(1f))
                    Icon(
                        modifier = Modifier
                            .padding(6.dp)
                            .size(28.dp),
                        imageVector = Icons.Default.Search,
                        contentDescription = null
                    )
                    Icon(
                        modifier = Modifier.size(28.dp),
                        imageVector = Icons.Default.Notifications,
                        contentDescription = null
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 52.dp,
                        ),
                    contentAlignment = Alignment.Center
                ){
                    SubcomposeAsyncImage(
                        modifier = Modifier
                            .clickable {
                                onClickItem(
                                    state.sectionName,
                                    state.playlistName,
                                    state.videoId,
                                    state.videoTitle,
                                )
                            }
                            .fillMaxWidth()
                            .height(200.dp)
                        ,
                        loading = {
                            Box(
                                modifier = Modifier,
                                contentAlignment = Alignment.Center
                            ){
                                CircularProgressIndicator()
                            }
                        },
                        model = state.videoThumbnail,
                        contentDescription = null,
                        alignment = Alignment.Center
                    )
                }

            }
        }
        items(state.sections) { section ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 4.dp, bottom = 2.dp, start = 16.dp, end = 16.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = section.name,
                    modifier = Modifier,
                )
                Text(
                    text = "المزيد",
                    modifier = Modifier,
                )
            }
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)//.size(width = 180.dp, height = 200.dp),
                , contentPadding = PaddingValues(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(section.playlists) { playlist ->
                    Column(
                        modifier = Modifier.clickable {
                            onClickItem(
                                section.name,
                                playlist.name,
                                playlist.videos.first().videoId,
                                playlist.videos.first().title
                            )
                        },
                    ) {
                        SubcomposeAsyncImage(
                            modifier = Modifier
                                .size(width = 140.dp, height = 140.dp),
                            alignment = Alignment.Center,
                            model = playlist.url,
                            loading = {
                                Box(
                                    modifier = Modifier,
                                    contentAlignment = Alignment.Center
                                ){
                                    CircularProgressIndicator()
                                }

                            },
                            error = {},
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                        Text(
                            modifier = Modifier
                                .size(width = 140.dp, height = 160.dp),
                            text = playlist.name,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                }
            }
        }
    }
}