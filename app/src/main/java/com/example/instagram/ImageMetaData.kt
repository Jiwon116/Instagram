package com.example.instagram

import com.google.gson.annotations.SerializedName

data class ImageMetaData(
    @SerializedName("total_count") val totalCount: Int?,
    @SerializedName("is_end") val isEnd: Boolean?
)
