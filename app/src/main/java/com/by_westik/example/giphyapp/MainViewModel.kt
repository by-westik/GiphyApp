package com.by_westik.example.giphyapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.by_westik.example.giphyapp.data.remote.Resource
import com.by_westik.example.giphyapp.domain.GiphyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    var repository: GiphyRepository
) : ViewModel() {

    fun getTrending() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repository.getTrending())
        } catch (e: Exception) {
            emit(Resource.Exception(e))
        }
    }
}