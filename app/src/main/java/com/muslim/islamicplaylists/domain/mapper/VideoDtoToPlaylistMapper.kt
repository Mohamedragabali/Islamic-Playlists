package com.muslim.islamicplaylists.domain.mapper

import com.muslim.islamicplaylists.data.network.dtos.VideoDto
import com.muslim.islamicplaylists.domain.model.Playlist
import com.muslim.islamicplaylists.domain.model.SubPlaylist
import com.muslim.islamicplaylists.domain.model.Video

class VideoDtoToPlaylistMapper:Mapper<VideoDto,List<Playlist>> {
    private val playListItems: MutableMap<String, MutableMap<String, MutableList<Video>>> = mutableMapOf()
    private val subPlayListItems: MutableMap<String, MutableList<Video>> = mutableMapOf()

    override fun map(input: VideoDto): List<Playlist> {
        input.allVideos?.map {
            it?.let {
                val category = it.category
                val subCategory = it.subCategory
                val video = Video(
                    id = getIdFromUrl(it.url),
                    title = it.title,
                    url = it.url,
                    thumbnail = getThumbnailFromUrl(it.url)
                )

                subPlayListItems
                    .getOrPut(subCategory) { mutableListOf() }
                    .add(video)

                val categoryMap = playListItems.getOrPut(category) { mutableMapOf() }
                categoryMap.getOrPut(subCategory) { mutableListOf() }.add(video)
            }
        }
        val playLists = mutableListOf<Playlist>()
        playListItems.forEach { playListsItem ->
            val subPlayLists = mutableListOf<SubPlaylist>()
            playListsItem.value.forEach { supPlayList ->
                subPlayLists.add(
                    SubPlaylist(
                        name = supPlayList.key,
                        videos = supPlayList.value
                    )
                )
            }
            playLists.add(
                Playlist(
                    name = playListsItem.key,
                    subPlayLists = subPlayLists
                )
            )
        }
        return playLists
    }

    private fun getThumbnailFromUrl(url: String):String{
        val id = getIdFromUrl(url)
        return "https://i.ytimg.com/vi/$id/sddefault.jpg"
    }
    private fun getIdFromUrl(url: String): String {
        return url.substring(url.indexOf('=')+1,url.indexOf('&'))
    }
}