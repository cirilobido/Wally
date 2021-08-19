package com.cirilobido.wally.data.model

import androidx.annotation.ColorInt
import com.google.gson.annotations.SerializedName

data class PhotoModel(@SerializedName("id") val id: String,
                      @SerializedName("color") val averageColor: String,
                      @SerializedName("description") val title: String,
                      @SerializedName("urls") val photoResolutions: PhotoResolutionModel)
