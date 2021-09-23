package com.example.daggerhilt_playground.network

import retrofit2.http.GET

interface BlogRetrofit {

    @GET("blogs")
    suspend fun getAllOfBlogs(): List<BlogNetworkEntity>
}