package com.muslim.islamicplaylists.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muslim.islamicplaylists.domain.model.Playlist
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
    private val _state = MutableStateFlow("")
    val state = _state.asStateFlow()
    init {
        getAllVideos()
    }

    private fun getAllVideos() {
        viewModelScope.launch {
            try{
                val result : List<Playlist> =  getAllVideosUseCase()
                _state.update {
                    result.toString()
                }
            }catch (e:Exception){
                _state.update {
                    "${e.message}"
                }
            }

        }
    }

}