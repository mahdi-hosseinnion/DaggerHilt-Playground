package com.example.daggerhilt_playground.di

import com.example.daggerhilt_playground.datasources.cache.BlogDao
import com.example.daggerhilt_playground.datasources.network.BlogRetrofit
import com.example.daggerhilt_playground.datasources.repositories.MainRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideMainRepository(blogDao: BlogDao, blogRetrofit: BlogRetrofit): MainRepository =
        MainRepository(
            blogDao = blogDao,
            blogRetrofit = blogRetrofit
        )
}

