package com.muslim.islamicplaylists.data.network.apiservice

import com.muslim.islamicplaylists.data.network.dtos.VideoDto
import retrofit2.http.GET

interface VideosApiService {
    @GET("MahmoudMabrok/MyDataCenter/main/ramadan.json")
    suspend fun getAllVideos(): VideoDto
}