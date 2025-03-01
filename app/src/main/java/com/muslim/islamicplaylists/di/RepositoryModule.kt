package com.muslim.islamicplaylists.di

import com.muslim.islamicplaylists.data.network.apiservice.VideosApiService
import com.muslim.islamicplaylists.data.repository.VideosRepository
import com.muslim.islamicplaylists.data.repository.VideosRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// todo i think repo should not be Singleton 
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideVideosRepository(
        apiService: VideosApiService
    ):VideosRepository{
        return VideosRepositoryImpl( apiService)
    }
}