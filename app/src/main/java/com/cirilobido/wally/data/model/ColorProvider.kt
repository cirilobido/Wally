package com.cirilobido.wally.data.model

import android.graphics.Color
import javax.inject.Inject

class ColorProvider @Inject constructor(){
    val colors = listOf<ColorModel>(
        ColorModel(
            colorName = "yellow",
            colorValue = Color.parseColor("#FDD835")
        ),
        ColorModel(
            colorName = "orange",
            colorValue = Color.parseColor("#FF9800")
        ),
        ColorModel(
            colorName = "red",
            colorValue = Color.parseColor("#E53935")
        ),
        ColorModel(
            colorName = "purple",
            colorValue = Color.parseColor("#9C27B0")
        ),
        ColorModel(
            colorName = "magenta",
            colorValue = Color.parseColor("#E91E63")
        ),
        ColorModel(
            colorName = "green",
            colorValue = Color.parseColor("#4CAF50")
        ),
        ColorModel(
            colorName = "teal",
            colorValue = Color.parseColor("#009688")
        ),
        ColorModel(
            colorName = "blue",
            colorValue = Color.parseColor("#2196F3")
        ),
        ColorModel(
            colorName = "white",
            colorValue = Color.parseColor("#ECEFF1")
        ),
        ColorModel(
            colorName = "black",
            colorValue = Color.BLACK
        )
    )
}