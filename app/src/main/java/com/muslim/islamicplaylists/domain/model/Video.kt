package com.muslim.islamicplaylists.domain.model

data class Video(
    val videoId :String = "" ,
    val title : String = "",
    val url :String ="",
    val thumbnail:String ="",
    val playlistName: String = "",
    val sectionName:String = ""
)
