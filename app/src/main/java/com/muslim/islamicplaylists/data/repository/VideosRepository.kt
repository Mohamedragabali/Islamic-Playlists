package com.muslim.islamicplaylists.data.repository

import com.muslim.islamicplaylists.data.network.apiservice.VideosApiService
import javax.inject.Inject

// todo we can use also interface for repo 
class VideosRepository @Inject constructor(
    private val apiService: VideosApiService
) {
    suspend fun getAllVideos()= apiService.getAllVideos()

}