package com.by_westik.example.giphyapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Giphy(
    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("images")
    val images:  @RawValue Images
)  : Parcelable
