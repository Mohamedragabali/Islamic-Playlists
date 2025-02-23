package com.muslim.islamicplaylists.data.network.dtos


import com.google.gson.annotations.SerializedName

data class VideoDto(
    @SerializedName("data")
    val allVideos: List<Data?>?
)