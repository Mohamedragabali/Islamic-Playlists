package com.muslim.islamicplaylists.data.repository

import com.muslim.islamicplaylists.data.network.apiservice.VideosApiService
import javax.inject.Inject


class VideosRepository @Inject constructor(
    private val apiService: VideosApiService
) {
    suspend fun getAllVideos()= apiService.getAllVideos()

}