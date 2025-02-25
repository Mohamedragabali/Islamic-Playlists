package com.muslim.islamicplaylists.screens.detials

import androidx.compose.ui.Modifier
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

private const val ROUTE = "VideoDetailScreen"
fun NavController.navigateToVideoDetailScreen(
    sectionName:String,
    playlistName : String ,
    videoId:String,
    videoTitle : String
){
    navigate("$ROUTE/$sectionName/$playlistName/$videoId/$videoTitle")
}
fun NavGraphBuilder.videoDetailsScreenRoute(
    navController: NavController,
    modifier: Modifier
) {
    composable(ROUTE+
                "/{${VideoDetailsScreenArgs.SECTION_NAME}}" +
                "/{${VideoDetailsScreenArgs.PLAYLIST_NAME}}" +
                "/{${VideoDetailsScreenArgs.VIDEO_ID}}" +
                "/{${VideoDetailsScreenArgs.VIDEO_TITLE}}",
        arguments = listOf(
            navArgument(VideoDetailsScreenArgs.SECTION_NAME){NavType.StringType},
            navArgument(VideoDetailsScreenArgs.PLAYLIST_NAME){NavType.StringType},
            navArgument(VideoDetailsScreenArgs.VIDEO_ID){NavType.StringType},
            navArgument(VideoDetailsScreenArgs.VIDEO_TITLE){NavType.StringType}
        )
    ){
        VideoDetailScreen(
            navController = navController,
            modifier = modifier
        )
    }
}
class VideoDetailsScreenArgs(
    savedStateHandle: SavedStateHandle
){
    val sectionName : String =checkNotNull(savedStateHandle[SECTION_NAME])
    val playListName : String =checkNotNull(savedStateHandle[PLAYLIST_NAME])
    val videoId : String  = checkNotNull(savedStateHandle[VIDEO_ID])
    val videoTitle : String = checkNotNull(savedStateHandle[VIDEO_TITLE])
    companion object{
        const val SECTION_NAME = "SectionName"
        const val PLAYLIST_NAME = "PlaylistName"
        const val VIDEO_ID = "VideoId"
        const val  VIDEO_TITLE = "VideoTitle"
    }
}