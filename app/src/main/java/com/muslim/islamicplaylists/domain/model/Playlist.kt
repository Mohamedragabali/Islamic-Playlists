package com.muslim.islamicplaylists.domain.model

data class Playlist(
    val name : String ="",
    val subPlayLists: List<SubPlaylist> = emptyList()
)
