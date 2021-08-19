package com.cirilobido.wally.data.network

import com.cirilobido.wally.BuildConfig
import com.cirilobido.wally.data.model.PhotoModel
import com.cirilobido.wally.data.model.TopicModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface UnsplashApiClient {
    @Headers("Authorization: ${BuildConfig.UNSPLASH_KEY}")
    @GET("photos?per_page=15&order_by=popular")
    suspend fun getPopularPhotos(): Response<List<PhotoModel>>

    @Headers("Authorization: ${BuildConfig.UNSPLASH_KEY}")
    @GET("topics?per_page=32&order_by=featured")
    suspend fun getTopics(): Response<List<TopicModel>>
}