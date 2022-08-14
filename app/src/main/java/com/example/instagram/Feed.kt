package com.example.instagram

data class Feed(
    var profileImg: String,
    var nickname: String,
    var like: Int?,
    var content: String,
    var tag: String?,
)