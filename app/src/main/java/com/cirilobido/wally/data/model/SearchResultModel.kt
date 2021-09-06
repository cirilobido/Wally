package com.cirilobido.wally.data.model

import com.google.gson.annotations.SerializedName

data class SearchResultModel(
        @SerializedName("total") val total: Long,
        @SerializedName("total_pages") val totalPages: Long,
        @SerializedName("results") val results: List<PhotoModel>)