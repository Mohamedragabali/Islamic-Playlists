package com.muslim.islamicplaylists.data.repository

import com.muslim.islamicplaylists.data.network.dtos.PlaylistDto

interface VideosRepository {
    suspend fun getAllVideos() : PlaylistDto
}