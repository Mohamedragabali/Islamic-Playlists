package com.muslim.islamicplaylists.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muslim.islamicplaylists.domain.model.Playlist
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
    private val _state = MutableStateFlow(emptyList<Sections>())
    val state = _state.asStateFlow()
    init {
        getAllVideos()
    }

    private fun getAllVideos() {
        viewModelScope.launch {
            try{
                val result : List<Sections> =  getAllVideosUseCase()
                _state.update {
                    result
                }
            }catch (e:Exception){
                Log.i("MY_TAG",e.message.toString())
            }

        }
    }

}