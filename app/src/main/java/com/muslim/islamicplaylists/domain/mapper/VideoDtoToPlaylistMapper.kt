package com.muslim.islamicplaylists.domain.mapper

import com.muslim.islamicplaylists.data.network.dtos.PlaylistDto
import com.muslim.islamicplaylists.domain.model.Playlist
import com.muslim.islamicplaylists.domain.model.Sections
import com.muslim.islamicplaylists.domain.model.Video

class VideoDtoToPlaylistMapper:Mapper<PlaylistDto,List<Sections>> {
    override fun map(input: PlaylistDto): List<Sections> {
        val allPlaylist = input.items.groupBy {
            it.category
        }
       return input.sections.map {sectionItem->
            Sections(
                name = sectionItem.title,
                playlists = sectionItem.categories.map {playlistItem->
                    Playlist(
                        name = playlistItem.title,
                        url = playlistItem.url,
                        videos = allPlaylist[playlistItem.title]?.map {
                            Video(
                                videoId = getIdFromUrl(it.url) ,
                                title = it.title,
                                 url = it.url ,
                                thumbnail = getThumbnailFromUrl(it.url),
                                playlistName = it.category,
                                sectionName = sectionItem.title
                            )
                        } ?: emptyList()
                    )
                }
            )
        }
    }

    private fun getThumbnailFromUrl(url: String):String{
        val id = getIdFromUrl(url)
        return "https://i.ytimg.com/vi/$id/maxresdefault.jpg"
    }
    private fun getIdFromUrl(url: String): String {
        return url.substring(url.indexOf('=')+1,url.indexOf('&'))
    }
}