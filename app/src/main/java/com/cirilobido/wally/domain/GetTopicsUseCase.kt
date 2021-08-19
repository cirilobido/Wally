package com.cirilobido.wally.domain

import com.cirilobido.wally.data.DataRepository
import com.cirilobido.wally.data.model.TopicModel
import javax.inject.Inject

class GetTopicsUseCase @Inject constructor(private val repository: DataRepository) {
    suspend operator fun invoke(): List<TopicModel>? = repository.getTopics()

}