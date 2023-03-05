package com.by_westik.example.giphyapp.data.remote

import com.by_westik.example.giphyapp.data.model.Data
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("gifs/trending")

    suspend fun getTrendingData(
        @Query("limit") limit: Int
    ): Data

    @GET("gifs/search")
    suspend fun getSearchingData(
        @Query("q") query: String,
        @Query("limit") limit: Int): Data

}