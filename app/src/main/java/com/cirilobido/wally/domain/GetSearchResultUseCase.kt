package com.cirilobido.wally.domain

import com.cirilobido.wally.data.DataRepository
import com.cirilobido.wally.data.model.SearchResultModel
import javax.inject.Inject

class GetSearchResultUseCase @Inject constructor(private val repository: DataRepository) {
    suspend operator fun invoke(page: Int, queryParam: String, color: String?): SearchResultModel = repository.getSearchResult(page, queryParam, color)
}