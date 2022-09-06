package com.example.instagram

import com.google.gson.annotations.SerializedName

data class ImageSearchResponse(
    @SerializedName("meta") val metaData: ImageMetaData?,
    @SerializedName("documents") var documents: MutableList<ImageSearch>?
)