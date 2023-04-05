package com.example.musicwiki.di

import com.example.musicwiki.api.services.EndPoints
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.example.musicwiki.repository.MainRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideService(service: EndPoints): MainRepository = MainRepository(service)
}