package com.muslim.islamicplaylists.domain.model

data class Sections(
    val name : String ="",
    val playlists: List<Playlist> = emptyList()
)
