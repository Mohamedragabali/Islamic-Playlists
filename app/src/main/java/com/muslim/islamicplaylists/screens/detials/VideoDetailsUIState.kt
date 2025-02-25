package com.muslim.islamicplaylists.screens.detials

import com.muslim.islamicplaylists.domain.model.Video

data class VideoDetailsUIState(
    val videoId :String = "",
    val videoTitle:String="",
    val playlistName : String ="",
    val videos: List<Video> = emptyList(),
    val isLoading : Boolean = false ,
    val isError: Boolean = false,
    val errorMessage:  String = ""
)

