package com.muslim.islamicplaylists.screens.detials

sealed class VideoDetailsUIState() {
    data class Data(
        val videoId: String = "",
        val videoTitle: String = "",
        val playlistName: String = "",
        val videos: List<VideoUIState> = emptyList(),
    ) :VideoDetailsUIState()

    data class Error(
        val message:String
    ):VideoDetailsUIState()
    data object Loading :VideoDetailsUIState()
}

data class VideoUIState(
    val videoId :String = "" ,
    val title : String = "",
    val url :String ="",
    val thumbnail:String ="",
    val playlistName: String = "",
    val sectionName:String = ""
)