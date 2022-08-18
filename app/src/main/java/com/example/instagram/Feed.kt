package com.example.instagram

data class Feed(
    var feedImg: Int,
    var nickname: String,
    var like:Int?,
    var content: String,
    var tag: ArrayList<String>?,
)