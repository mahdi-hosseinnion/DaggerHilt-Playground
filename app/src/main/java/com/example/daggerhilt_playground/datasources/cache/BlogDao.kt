package com.example.daggerhilt_playground.datasources.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BlogDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBlog(blog: BlogCacheEntity): Long

    @Query("SELECT * FROM blogs")
    suspend fun getAllOfBlogs(): List<BlogCacheEntity>
}