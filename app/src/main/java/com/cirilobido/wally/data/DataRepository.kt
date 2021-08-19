package com.cirilobido.wally.data

import com.cirilobido.wally.data.model.ColorModel
import com.cirilobido.wally.data.model.ColorProvider
import com.cirilobido.wally.data.model.PhotoModel
import com.cirilobido.wally.data.model.TopicModel
import com.cirilobido.wally.data.network.UnsplashService
import javax.inject.Inject

class DataRepository @Inject constructor(private val apiService: UnsplashService, private val colorProvider: ColorProvider) {
    suspend fun getPopularPhotos(): List<PhotoModel> = apiService.getPopularPhotos()
    suspend fun getTopics(): List<TopicModel> = apiService.getTopics()

    fun getColors(): List<ColorModel> = colorProvider.colors
}