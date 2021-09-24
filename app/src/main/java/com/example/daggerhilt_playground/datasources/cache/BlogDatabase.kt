package com.example.daggerhilt_playground.datasources.cache

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BlogCacheEntity::class], version = 1)
abstract class BlogDatabase : RoomDatabase() {

    abstract fun blogDao(): BlogDao

    companion object {
        const val DATABASE_NAME = "blog_db"
    }
}