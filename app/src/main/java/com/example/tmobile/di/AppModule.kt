package com.example.tmobile.di

import com.example.tmobile.data.repository.AuthRepositoryImpl
import com.example.tmobile.domain.repo.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideAuthRepo(repositoryImpl: AuthRepositoryImpl): AuthRepository {
        return repositoryImpl
    }

}