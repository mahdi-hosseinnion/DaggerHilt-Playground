package com.example.daggerhilt_playground.di

import android.content.Context
import androidx.room.Room
import com.example.daggerhilt_playground.datasources.cache.BlogDao
import com.example.daggerhilt_playground.datasources.cache.BlogDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)

object CacheModule {

    @Singleton
    @Provides
    fun provideBlogDatabase(@ApplicationContext context: Context): BlogDatabase =
        Room.databaseBuilder(
            context, BlogDatabase::class.java,
            BlogDatabase.DATABASE_NAME
        ).fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideBlogDao(db: BlogDatabase): BlogDao = db.blogDao()

}