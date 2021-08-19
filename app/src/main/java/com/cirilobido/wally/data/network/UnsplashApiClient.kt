package com.cirilobido.wally.data.network

import com.cirilobido.wally.BuildConfig
import com.cirilobido.wally.data.model.PhotoModel
import com.cirilobido.wally.data.model.TopicModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface UnsplashApiClient {
    @GET("photos?per_page=15&order_by=popular")
    suspend fun getPopularPhotos(@Header("Authorization") key: String): Response<List<PhotoModel>>

    @GET("topics?per_page=32&order_by=featured")
    suspend fun getTopics(@Header("Authorization") key: String): Response<List<TopicModel>>
}