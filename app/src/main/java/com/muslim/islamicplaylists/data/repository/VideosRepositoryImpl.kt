package com.muslim.islamicplaylists.data.repository

import com.muslim.islamicplaylists.data.network.apiservice.VideosApiService
import com.muslim.islamicplaylists.data.network.dtos.PlaylistDto
import javax.inject.Inject

class VideosRepositoryImpl @Inject constructor(
    private val apiService: VideosApiService
) :VideosRepository{
    override suspend fun getAllVideos(): PlaylistDto {
        return apiService.getAllVideos()
    }

}