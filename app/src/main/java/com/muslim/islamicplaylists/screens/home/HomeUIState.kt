package com.muslim.islamicplaylists.screens.home

sealed class HomeUIState {
    data class Data(
        val userName: String = "",
        val sectionName :String = "",
        val playlistName : String = "",
        val videoId : String = "",
        val videoTitle : String ="",
        val videoThumbnail :String ="",
        val sections: List<SectionsUIState> = emptyList(),
    ) : HomeUIState()

    data class Error(
        val message:String
    ): HomeUIState()
    data object Loading : HomeUIState()
}

data class SectionsUIState(
    val name : String ="",
    val playlists: List<PlaylistUIState> = emptyList()
)

data class PlaylistUIState(
    val name : String ="",
    val url : String = "" ,
    val videos: List<VideoUIState> = emptyList()
)

data class VideoUIState(
    val videoId :String = "" ,
    val title : String = "",
    val url :String ="",
    val thumbnail:String ="",
    val playlistName: String = "",
    val sectionName:String = ""
)