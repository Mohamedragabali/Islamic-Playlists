package com.muslim.islamicplaylists.data.repository

import com.muslim.islamicplaylists.data.datasource.VideosDataSource
import com.muslim.islamicplaylists.data.network.dtos.PlaylistDto
import javax.inject.Inject

class VideosRepositoryImpl @Inject constructor(
    private val videosDataSource: VideosDataSource
) : VideosRepository {
     override suspend fun getAllVideos(): PlaylistDto {
        return videosDataSource.getAllVideos()
    }

}