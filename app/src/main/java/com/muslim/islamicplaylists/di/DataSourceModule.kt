package com.muslim.islamicplaylists.di

import com.muslim.islamicplaylists.data.datasource.VideosDataSource
import com.muslim.islamicplaylists.data.network.apiservice.VideosApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideVideosDataSource(
        apiService:VideosApiService
    ):VideosDataSource{
        return VideosDataSource(apiService)
    }
}