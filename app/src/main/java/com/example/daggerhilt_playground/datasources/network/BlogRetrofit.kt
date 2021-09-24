package com.example.daggerhilt_playground.datasources.network

import retrofit2.http.GET

interface BlogRetrofit {

    @GET("blogs")
    suspend fun getAllOfBlogs(): List<BlogNetworkEntity>
}