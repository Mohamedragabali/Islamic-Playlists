package com.muslim.islamicplaylists.screens.detials

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerCallback
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

@Composable
fun VideoDetailScreen(
    viewModel: VideoDetailsScreenViewModel = hiltViewModel(),
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val state by viewModel.state.collectAsState()
    VideoDetailScreenContent(
        state,
        modifier = modifier,
        viewModel::onClickItem
    )
}

@Composable
private fun VideoDetailScreenContent(
    state: VideoDetailsUIState,
    modifier: Modifier,
    onClickItem: (videoId: String, videoTitle: String) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        if (state.isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }

        } else if (state.isError) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center

            ) {
                Text("please check your internet")
            }
        } else {
            AndroidView(
                factory = {
                    val youTubePlayerView = YouTubePlayerView(it).apply {
                        enableAutomaticInitialization = false
                        addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                            override fun onReady(youTubePlayer: YouTubePlayer) {
                                youTubePlayer.cueVideo(state.videoId, 0f)
                            }
                        }
                        )
                    }
                    youTubePlayerView

                }, update = { youtubePlayer ->
                    youtubePlayer.getYouTubePlayerWhenReady(object : YouTubePlayerCallback {
                        override fun onYouTubePlayer(youTubePlayer: YouTubePlayer) {
                            youTubePlayer.cueVideo(state.videoId, 0f)
                        }

                    })
                }
            )
            Row(
                modifier = Modifier,
               verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(
                            start = 16.dp,
                            top = 16.dp,
                            bottom = 16.dp
                        )
                ){
                    Column {
                        Text(
                            text = state.videoTitle
                        )
                        Text(
                            text = state.playlistName,

                        )
                    }

                }
                Icon(
                    modifier = Modifier.padding(
                        start =2.dp ,
                        end = 16.dp,
                        top = 16.dp,
                        bottom = 16.dp
                    ),
                    imageVector = Icons.Default.Star,
                    contentDescription = null
                )
            }
            Text(
                modifier = Modifier.padding(
                    top = 2.dp,
                    bottom = 1.dp,
                    start = 16.dp,
                    end = 16.dp ),
                text = "المزيد من الفديوهات",
                textDecoration = TextDecoration.Underline
            )
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(state.videos) {
                    Row (
                       verticalAlignment = Alignment.CenterVertically,
                    ){
                        SubcomposeAsyncImage(
                            modifier = Modifier
                                .clickable { onClickItem(it.videoId, it.title) }
                                .width(160.dp)
                                .height(120.dp)
                                .padding(
                                    end = 6.dp
                                ),
                            loading = {
                                Box(
                                    contentAlignment = Alignment.Center
                                ){
                                    CircularProgressIndicator()

                                }
                            },
                            model = it.thumbnail,
                            contentDescription = null,
                            error = {
                                Text(
                                    text = state.errorMessage
                                )
                            }
                        )
                        Text(
                            text = it.title,
                        )

                    }

                }
            }
        }

    }
}
