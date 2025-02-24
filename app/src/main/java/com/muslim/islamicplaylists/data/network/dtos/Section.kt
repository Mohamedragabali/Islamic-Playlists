package com.muslim.islamicplaylists.data.network.dtos


import com.google.gson.annotations.SerializedName

data class Section(
    @SerializedName("categories")
    val categories: List<Category> = listOf(),
    @SerializedName("title")
    val title: String = ""
)