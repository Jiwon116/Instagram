package com.example.instagram

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ImageSearchRetrofitInterface {
    @GET("v2/search/image")
    fun getImageSearch(
        @Header("Authorization") apiKey: String = "KakaoAK eb9958ff152a6b6172de3317cadf9f2f",
        @Query("query") query : String,
        @Query("sort") sort : String,
        @Query("page") page: Int,
        @Query("size") size: Int
    ) : Call<ImageSearchResponse>
}