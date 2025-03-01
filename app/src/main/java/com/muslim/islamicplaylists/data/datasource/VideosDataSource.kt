package com.muslim.islamicplaylists.data.datasource

import com.muslim.islamicplaylists.data.network.apiservice.VideosApiService
import com.muslim.islamicplaylists.data.network.dtos.PlaylistDto
import javax.inject.Inject

class VideosDataSource@Inject constructor(
    private val apiService: VideosApiService
) {
    suspend fun getAllVideos(): PlaylistDto {
        return apiService.getAllVideos()
    }
}