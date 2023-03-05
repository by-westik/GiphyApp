package com.by_westik.example.giphyapp.data.remote

import com.by_westik.example.giphyapp.data.model.Data
import retrofit2.http.GET

interface ApiService {

    @GET("gifs/trending")
    suspend fun getTrendingData(): Data

}