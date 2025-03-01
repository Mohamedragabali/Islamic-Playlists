package com.muslim.islamicplaylists.di

import com.muslim.islamicplaylists.data.network.apiservice.VideosApiService
import com.muslim.islamicplaylists.data.repository.VideosRepository
import com.muslim.islamicplaylists.data.repository.VideosRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideVideosRepository(
        apiService: VideosApiService
    ):VideosRepository{
        return VideosRepositoryImpl( apiService)
    }
}