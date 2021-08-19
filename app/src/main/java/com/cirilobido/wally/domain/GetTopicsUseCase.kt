package com.cirilobido.wally.domain

import com.cirilobido.wally.data.DataRepository
import com.cirilobido.wally.data.model.TopicModel

class GetTopicsUseCase {
    private val repository = DataRepository()

    suspend operator fun invoke(): List<TopicModel>? = repository.getTopics()

}