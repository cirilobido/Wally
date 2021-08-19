package com.cirilobido.wally.domain

import com.cirilobido.wally.data.DataRepository
import com.cirilobido.wally.data.model.ColorModel
import javax.inject.Inject

class GetColorsUseCase @Inject constructor(private val repository: DataRepository) {
    operator fun invoke(): List<ColorModel>? = repository.getColors()
}