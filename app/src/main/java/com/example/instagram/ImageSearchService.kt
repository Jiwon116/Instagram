package com.example.instagram

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Header
import retrofit2.http.Query

class ImageSearchService {
    private lateinit var imageSearchView: ImageSearchView

    fun setImageSearchService(imageSearchView: ImageSearchView) {
        this.imageSearchView = imageSearchView
    }

    fun getImageSearch(apiKey: String, query : String, sort : String, page: Int, size: Int) {
        val imageSearchService = getRetrofit().create(ImageSearchRetrofitInterface::class.java)

        imageSearchView.onGetImageSearchLoading()

        imageSearchService.getImageSearch(apiKey, query, sort, page, size)
            .enqueue(object :retrofit2.Callback<ImageSearchResponse>{
                override fun onResponse(
                    call: Call<ImageSearchResponse>,
                    response: Response<ImageSearchResponse>
                ) {
                    TODO("Not yet implemented")
                }

                override fun onFailure(call: Call<ImageSearchResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
    }


}