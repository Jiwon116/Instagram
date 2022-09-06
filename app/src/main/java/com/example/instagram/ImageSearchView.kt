package com.example.instagram

interface ImageSearchView {
    fun onGetImageSearchLoading()
    fun onGetImageSearchSuccess(result: ImageSearch?)
    fun onGetImageSearchFailure(code:Int, message:String)
}