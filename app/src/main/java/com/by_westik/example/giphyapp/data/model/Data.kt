package com.by_westik.example.giphyapp.data.model

import com.google.gson.annotations.SerializedName

data class Data(
    @field:SerializedName("data")
    val data: List<Giphy>
)
