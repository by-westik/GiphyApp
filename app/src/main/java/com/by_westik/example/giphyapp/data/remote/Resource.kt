package com.by_westik.example.giphyapp.data.remote

sealed class Resource<out T> {
    class Loading<out T> : Resource<T>()
    data class Success<out T>(val data: T) : Resource<T>()
    data class Exception<out T>(val exception: java.lang.Exception) : Resource<T>()
}