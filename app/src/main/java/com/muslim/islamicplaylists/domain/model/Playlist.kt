package com.muslim.islamicplaylists.domain.model

data class Playlist(
    val name : String ="",
    val url : String = "" ,
    val videos: List<Video> = emptyList()
)
