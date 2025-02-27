package com.muslim.islamicplaylists.data.network.apiservice

import com.muslim.islamicplaylists.data.network.dtos.PlaylistDto
import retrofit2.http.GET

// todo use layer as abstraction between retrofit and repo 
interface VideosApiService {
    @GET("MahmoudMabrok/MyDataCenter/main/ramadan.json")
    suspend fun getAllVideos(): PlaylistDto
}