package com.muslim.islamicplaylists.data.network.dtos


import com.google.gson.annotations.SerializedName

data class PlaylistDto(
    @SerializedName("items")
    val items: List<Item> = listOf(),
    @SerializedName("sections")
    val sections: List<Section> = listOf()
)