package com.cirilobido.wally.data.network

import com.cirilobido.wally.BuildConfig
import com.cirilobido.wally.data.model.PhotoModel
import com.cirilobido.wally.data.model.SearchResultModel
import com.cirilobido.wally.data.model.TopicModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UnsplashApiClient {
    private companion object {
        const val orientation: String = "&orientation=portrait"
        const val postPerPage: String = "&per_page=15"
    }
    @Headers("Authorization: ${BuildConfig.UNSPLASH_KEY}")
    @GET("photos?order_by=popular$postPerPage$orientation")
    suspend fun getPopularPhotos(): Response<List<PhotoModel>>

    @Headers("Authorization: ${BuildConfig.UNSPLASH_KEY}")
    @GET("topics?per_page=32&order_by=featured$orientation")
    suspend fun getTopics(): Response<List<TopicModel>>

    @Headers("Authorization: ${BuildConfig.UNSPLASH_KEY}")
    @GET("/search/photos?order_by=latest$postPerPage$orientation")
    suspend fun getSearch(@Query("page") page: Int,
                          @Query("query") queryParam: String,
                          @Query("color") color: String?): SearchResultModel
}