package com.by_westik.example.giphyapp.data.model

import com.google.gson.annotations.SerializedName

data class Images(
    @field:SerializedName("preview_gif")
    val preview_gif: Preview
)
