package com.muslim.islamicplaylists.domain.usecase

import com.muslim.islamicplaylists.data.repository.VideosRepository
import com.muslim.islamicplaylists.domain.mapper.VideoDtoToPlaylistMapper
import com.muslim.islamicplaylists.domain.model.Playlist
import javax.inject.Inject

class GetAllVideosUseCase @Inject constructor(
    private val videosRepository :VideosRepository,
    private val mapper : VideoDtoToPlaylistMapper
) {
    suspend operator fun invoke() : List<Playlist>{
        return mapper.map(videosRepository.getAllVideos())
    }
}