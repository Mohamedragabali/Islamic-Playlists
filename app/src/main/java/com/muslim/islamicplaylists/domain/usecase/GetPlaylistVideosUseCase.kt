package com.muslim.islamicplaylists.domain.usecase

import com.muslim.islamicplaylists.data.repository.VideosRepository
import com.muslim.islamicplaylists.domain.mapper.VideoDtoToPlaylistMapper
import com.muslim.islamicplaylists.domain.model.Video
import javax.inject.Inject

class GetPlaylistVideosUseCase@Inject constructor(
    private val videosRepository : VideosRepository,
    private val mapper : VideoDtoToPlaylistMapper
) {
    suspend operator fun invoke(
        sectionName:String,
        playlistName:String
    ):List<Video> {
        val result = mapper
            .map(
                videosRepository
                    .getAllVideos()
            ).find {
                it.name == sectionName
            }?.playlists?.find {
                it.name == playlistName
            }?.videos ?: emptyList()

        return result
    }
}