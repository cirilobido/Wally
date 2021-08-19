package com.cirilobido.wally.data.network

import android.util.Log
import com.cirilobido.wally.BuildConfig
import com.cirilobido.wally.core.RetrofitHelper
import com.cirilobido.wally.data.model.PhotoModel
import com.cirilobido.wally.data.model.TopicModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.lang.Exception

class UnsplashService {

    private val retrofit = RetrofitHelper.getRetrofit()
    private val apiKey: String = BuildConfig.UNSPLASH_KEY;

    suspend fun getPopularPhotos(): List<PhotoModel>{
        return withContext(Dispatchers.IO) {
            try {
                val response = retrofit.create(UnsplashApiClient::class.java)
                    .getPopularPhotos(apiKey)
                response.body() ?: emptyList()
            } catch (e: Exception){
                emptyList()
            }
        }
    }

    suspend fun getTopics(): List<TopicModel>{
        return withContext(Dispatchers.IO){
            try {
                val response = retrofit.create(UnsplashApiClient::class.java)
                        .getTopics(apiKey)
                response.body() ?: emptyList()
            } catch (e: Exception){
                emptyList()
            }
        }
    }
}