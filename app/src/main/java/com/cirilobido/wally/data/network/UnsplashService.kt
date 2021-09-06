package com.cirilobido.wally.data.network

import android.util.Log
import com.cirilobido.wally.data.model.PhotoModel
import com.cirilobido.wally.data.model.SearchResultModel
import com.cirilobido.wally.data.model.TopicModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class UnsplashService @Inject constructor(private val apiClient: UnsplashApiClient) {

    suspend fun getPopularPhotos(): List<PhotoModel>{
        return withContext(Dispatchers.IO) {
            try {
                val response = apiClient
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
                val response = apiClient
                        .getTopics()
                response.body() ?: emptyList()
            } catch (e: Exception){
                emptyList()
            }
        }
    }

    suspend fun getSearch(page: Int, queryParam: String, color: String?): SearchResultModel{
        return withContext(Dispatchers.IO){
            try{
                val response = apiClient.getSearch(page, queryParam, color)
                response
            } catch (e: Exception){
                emptyList<SearchResultModel>()
            } as SearchResultModel
        }
    }
}