package com.muslim.islamicplaylists.data.network.dtos


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("category")
    val category: String = "",
    @SerializedName("subCategory")
    val subCategory: String = "",
    @SerializedName("title")
    val title: String = "",
    @SerializedName("url")
    val url: String = ""
)