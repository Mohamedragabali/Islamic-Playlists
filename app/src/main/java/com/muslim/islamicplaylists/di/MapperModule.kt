package com.muslim.islamicplaylists.di

import com.muslim.islamicplaylists.domain.mapper.VideoDtoToPlaylistMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Provides
    fun provideVideoDtoToPlaylistMapper() :VideoDtoToPlaylistMapper{
        return VideoDtoToPlaylistMapper()
    }
}