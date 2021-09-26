package com.example.daggerhilt_playground.datasources.repositories

import com.example.daggerhilt_playground.datasources.cache.BlogDao
import com.example.daggerhilt_playground.datasources.cache.CacheMapper.mapToDomainList
import com.example.daggerhilt_playground.datasources.cache.CacheMapper.mapToEntity
import com.example.daggerhilt_playground.datasources.network.BlogRetrofit
import com.example.daggerhilt_playground.datasources.network.NetworkMapper.mapToDomainList
import com.example.daggerhilt_playground.domain.models.Blog
import com.example.daggerhilt_playground.domain.utils.DataState
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository
@Inject
constructor(
    private val blogDao: BlogDao,
    private val blogRetrofit: BlogRetrofit
) {

    fun getBlogs(): Flow<DataState<List<Blog>>> = flow {

        emit(DataState.Loading)
        delay(2000)

        try {
            //get blogs from network
            val networkResult = runInIODispatcher { blogRetrofit.getAllOfBlogs() }
            //insert blogs into cache
            for (item in networkResult.mapToDomainList()) {
                runInIODispatcher { blogDao.insertBlog(item.mapToEntity()) }
            }
            //get all of result from cache
            val cacheResponse = runInIODispatcher { blogDao.getAllOfBlogs() }
            //return data received from cache
            emit(DataState.Success(cacheResponse.mapToDomainList()))

        } catch (e: Exception) {
            //cache error and show it to user
            emit(DataState.Error(e))
        }
    }

    private suspend fun <T> runInIODispatcher(block: suspend () -> T): T = withContext(IO) {
        return@withContext block.invoke()
    }
}
