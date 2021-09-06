package com.cirilobido.wally.domain

import com.cirilobido.wally.data.DataRepository
import com.cirilobido.wally.data.model.PhotoModel
import javax.inject.Inject

class GetPopularPhotosUseCase @Inject constructor(private val repository: DataRepository) {
    suspend operator fun invoke(): List<PhotoModel>? = repository.getPopularPhotos()
}