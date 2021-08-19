package com.cirilobido.wally.ui.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.cirilobido.wally.R
import com.cirilobido.wally.data.model.ColorModel
import com.cirilobido.wally.databinding.ItemColorBinding

class ColorsAdapter(val colorList: List<ColorModel>): RecyclerView.Adapter<ColorsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_color,  parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(colorList[position])
    }

    override fun getItemCount(): Int = colorList.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        private val binding = ItemColorBinding.bind(view)

        fun bind(colorList: ColorModel){
            binding.cardViewColor.setCardBackgroundColor(colorList.colorValue)
        }
    }
}