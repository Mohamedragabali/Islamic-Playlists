package com.muslim.islamicplaylists.screens.detials

import android.provider.MediaStore
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muslim.islamicplaylists.domain.model.Video
import com.muslim.islamicplaylists.domain.usecase.GetPlaylistVideosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VideoDetailsScreenViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getPlaylistVideos: GetPlaylistVideosUseCase
) : ViewModel() {

    private val _state: MutableStateFlow<VideoDetailsUIState> =
        MutableStateFlow(VideoDetailsUIState.Loading)
    val state = _state.asStateFlow()

    private val args = VideoDetailsScreenArgs(savedStateHandle)


    init {
        getVideoId()
    }

    fun onClickItem(videoId: String, videoTitle: String) {
        _state.update { currentState ->
            when (currentState) {
                is VideoDetailsUIState.Data -> currentState.copy(
                    videoId = videoId,
                    videoTitle = videoTitle
                )

                else -> currentState
            }
        }
    }

    private fun getVideoId() {
        viewModelScope.launch {
            try {
                val result: List<VideoUIState> = getPlaylistVideos(
                    sectionName = args.sectionName,
                    playlistName = args.playListName,
                ).map {
                    VideoUIState(
                        videoId =it.videoId,
                        title =it.title,
                        url =it.url,
                        thumbnail =it.thumbnail,
                        playlistName = it.playlistName,
                        sectionName = it.sectionName
                    )
                }
                _state.update {
                    VideoDetailsUIState.Data(
                        videoId = args.videoId,
                        videoTitle = args.videoTitle,
                        playlistName = args.playListName,
                        videos = result,
                    )
                }
            } catch (e: Exception) {
                _state.update {
                    VideoDetailsUIState.Error(
                        e.message.toString()
                    )
                }
            }

        }

    }


}