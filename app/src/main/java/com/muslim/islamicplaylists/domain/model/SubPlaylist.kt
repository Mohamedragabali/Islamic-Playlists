package com.muslim.islamicplaylists.domain.model

data class SubPlaylist(
    val name : String = "",
    val videos:List<Video> = emptyList()
)
