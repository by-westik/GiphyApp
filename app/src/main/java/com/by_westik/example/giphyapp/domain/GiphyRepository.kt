package com.by_westik.example.giphyapp.domain

import com.by_westik.example.giphyapp.data.model.Giphy
import com.by_westik.example.giphyapp.data.remote.ApiService
import com.by_westik.example.giphyapp.data.remote.Resource
import javax.inject.Inject


class GiphyRepository @Inject constructor(
    private val apiService: ApiService,
) {

    suspend fun getTrending(): Resource<List<Giphy>> {
        return Resource.Success(apiService.getTrendingData(25).data)
    }

    suspend fun searching(query: String): Resource<List<Giphy>> {
        return Resource.Success(apiService.getSearchingData(query, 25).data)
    }
}