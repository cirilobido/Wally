package com.cirilobido.wally.data.model

import com.google.gson.annotations.SerializedName
import retrofit2.http.Field

data class TopicModel (@SerializedName("id") val id: String,
                       @SerializedName("slug") val slug: String,
                       @SerializedName("title") val title: String,
                       @SerializedName("description") val description: String,
                       @SerializedName("total_photos") val total_photos: Int,
                       @SerializedName("cover_photo") val coverPhoto: PhotoModel)