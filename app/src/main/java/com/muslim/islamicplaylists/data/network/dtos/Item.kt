package com.muslim.islamicplaylists.data.network.dtos


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("category")
    val category: String = "",
    @SerializedName("title")
    val title: String = "",
    @SerializedName("url")
    val url: String = ""
)