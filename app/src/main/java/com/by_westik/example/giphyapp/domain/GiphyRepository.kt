package com.by_westik.example.giphyapp.domain

import com.by_westik.example.giphyapp.data.model.Giphy
import com.by_westik.example.giphyapp.data.remote.ApiService
import com.by_westik.example.giphyapp.data.remote.Resource
import javax.inject.Inject


class GiphyRepository @Inject constructor(
    private val apiService: ApiService,
) {

    suspend fun getTrending(): Resource<List<Giphy>> {
        return Resource.Success(apiService.getTrendingData().data)
    }

    suspend fun searching(query: String): Resource<List<Giphy>> {
        return Resource.Success(apiService.getSearchingData(query).data)
    }
}