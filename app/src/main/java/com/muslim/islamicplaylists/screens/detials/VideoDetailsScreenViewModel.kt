package com.muslim.islamicplaylists.screens.detials

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
): ViewModel() {

    private val _state:MutableStateFlow<VideoDetailsUIState> = MutableStateFlow(VideoDetailsUIState())
    val state = _state.asStateFlow()

    private val args = VideoDetailsScreenArgs(savedStateHandle)


    init {
        getVideoId()
    }
    fun onClickItem(videoId:String , videoTitle : String ){
        _state.update {
            it.copy(
                videoId = videoId ,
                videoTitle = videoTitle
            )
        }
    }
    private fun getVideoId() {
        viewModelScope.launch {
            try{
                _state.update {
                    it.copy(
                        videoId = args.videoId,
                        videoTitle = args.videoTitle,
                        playlistName = args.playListName,
                        isLoading = true
                    )
                }
                val result : List<Video> =  getPlaylistVideos(
                    sectionName = args.sectionName,
                    playlistName = args.playListName,
                )

                _state.update {
                    it.copy(
                        videos = result,
                        isLoading = false
                    )
                }
            }catch (e:Exception){
                _state.update {
                    it.copy(
                        isLoading = false,
                        isError = true,
                        errorMessage = e.message.toString()
                    )
                }
            }

        }

    }


}