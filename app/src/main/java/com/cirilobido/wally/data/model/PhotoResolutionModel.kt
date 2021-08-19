package com.cirilobido.wally.data.model

import androidx.annotation.ColorInt
import com.google.gson.annotations.SerializedName

data class PhotoResolutionModel(@SerializedName("raw") val original: String,
                                @SerializedName("full") val full: String,
                                @SerializedName("regular") val regular: String,
                                @SerializedName("small") val small: String,
                                @SerializedName("thumb") val thumb: String)
