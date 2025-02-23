package com.muslim.islamicplaylists.di

import com.muslim.islamicplaylists.data.network.apiservice.VideosApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Named("base_url")
    fun provideBaseUrl():String{
        return "https://raw.githubusercontent.com/"
    }
    @Singleton
    @Provides
    fun provideOkHttpClient():OkHttpClient{
        return OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor()).build()
    }

    @Singleton
    @Provides
    fun provideVideosApiService(
        @Named("base_url") baseUrl : String ,
        okHttpClient: OkHttpClient
    ):VideosApiService{
        val retrofit = Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(VideosApiService::class.java)
    }
}