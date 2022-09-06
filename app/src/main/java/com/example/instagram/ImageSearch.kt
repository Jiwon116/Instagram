package com.example.instagram

import com.google.gson.annotations.SerializedName

data class ImageSearch(
    @SerializedName("collection") val collection : String,
    @SerializedName("thumbnail_url") val thumbnail_url : String,
    @SerializedName("image_url") val image_url : String
)