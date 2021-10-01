package com.example.daggerhilt_playground.di

import com.example.daggerhilt_playground.datasources.cache.BlogDao
import com.example.daggerhilt_playground.datasources.network.BlogRetrofit
import com.example.daggerhilt_playground.datasources.repositories.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideMainRepository(blogDao: BlogDao, blogRetrofit: BlogRetrofit): MainRepository =
        MainRepository(
            blogDao = blogDao,
            blogRetrofit = blogRetrofit
        )

    @Singleton
    @Provides
    fun provideBlogName(): String = "Mahdi hosseinion awesome"

    @Singleton
    @Provides
    fun provideDate(): Date = Date()
}

