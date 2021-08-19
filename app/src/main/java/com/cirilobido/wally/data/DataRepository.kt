package com.cirilobido.wally.data

import com.cirilobido.wally.data.model.ColorModel
import com.cirilobido.wally.data.model.ColorProvider
import com.cirilobido.wally.data.model.PhotoModel
import com.cirilobido.wally.data.model.TopicModel
import com.cirilobido.wally.data.network.UnsplashService

class DataRepository {

    private val api = UnsplashService()

    suspend fun getPopularPhotos(): List<PhotoModel> = api.getPopularPhotos()
    suspend fun getTopics(): List<TopicModel> = api.getTopics()

    fun getColors(): List<ColorModel> = ColorProvider.getColors()
}