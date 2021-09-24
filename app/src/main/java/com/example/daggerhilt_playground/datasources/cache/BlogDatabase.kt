package com.example.daggerhilt_playground.datasources.cache

import androidx.room.Database

@Database(entities = [BlogCacheEntity::class], version = 1)
abstract class BlogDatabase {

    abstract fun blogDao():BlogDao

    companion object{
        const val DATABASE_NAME = "blog_db"
    }
}