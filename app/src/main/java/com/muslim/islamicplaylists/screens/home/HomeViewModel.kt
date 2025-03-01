package com.muslim.islamicplaylists.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muslim.islamicplaylists.domain.model.Sections
import com.muslim.islamicplaylists.domain.usecase.GetAllVideosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllVideosUseCase: GetAllVideosUseCase
): ViewModel() {
    private val _state:MutableStateFlow<HomeUIState> = MutableStateFlow(HomeUIState.Loading)
    val state = _state.asStateFlow()
    init {
        getAllVideos()
    }

    private fun getAllVideos() {
        viewModelScope.launch {
            try{
                val result : List<SectionsUIState> =
                    getAllVideosUseCase().map { section->
                        SectionsUIState(
                            name = section.name,
                            playlists = section.playlists.map {playlist ->
                                PlaylistUIState(
                                    name = playlist.name,
                                    url = playlist.url,
                                    videos =playlist.videos.map { video->
                                        VideoUIState(
                                            videoId = video.videoId,
                                         title = video.title,
                                         url = video.url,
                                         thumbnail = video.thumbnail,
                                         playlistName = video.playlistName,
                                         sectionName = video.sectionName
                                        )
                                    }
                                )
                            }
                        )
                    }
                _state.update {
                    HomeUIState.Data(
                         userName= "محمد رجب",
                        "الاستعداد لرمضان",
                        "شهر رمضان | د. أحمد عبد المنعم",
                        "SL2CdQ1cqKE",
                        "الاستغلال الأمثل لمواسم الطاعات | د. أحمد عبد المنعم",
                        "https://i.ytimg.com/vi/SL2CdQ1cqKE/maxresdefault.jpg",
                     sections= result,
                    )
                }
            }catch (e:Exception){
                Log.i("MY_TAG",e.message.toString())
            }

        }
    }

}