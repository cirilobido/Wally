package com.cirilobido.wally.data.network

import com.cirilobido.wally.data.model.PhotoModel
import com.cirilobido.wally.data.model.TopicModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class UnsplashService @Inject constructor(private val unsplashApiClient: UnsplashApiClient) {

    suspend fun getPopularPhotos(): List<PhotoModel>{
        return withContext(Dispatchers.IO) {
            try {
                val response = unsplashApiClient
                    .getPopularPhotos()
                response.body() ?: emptyList()
            } catch (e: Exception){
                emptyList()
            }
        }
    }

    suspend fun getTopics(): List<TopicModel>{
        return withContext(Dispatchers.IO){
            try {
                val response = unsplashApiClient
                        .getTopics()
                response.body() ?: emptyList()
            } catch (e: Exception){
                emptyList()
            }
        }
    }
}