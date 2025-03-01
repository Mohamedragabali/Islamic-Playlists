package com.muslim.islamicplaylists.di

import com.muslim.islamicplaylists.data.datasource.VideosDataSource
import com.muslim.islamicplaylists.data.repository.VideosRepository
import com.muslim.islamicplaylists.data.repository.VideosRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    fun provideVideosRepository(
        dataSource: VideosDataSource
    ):VideosRepository{
        return VideosRepositoryImpl( dataSource)
    }
}