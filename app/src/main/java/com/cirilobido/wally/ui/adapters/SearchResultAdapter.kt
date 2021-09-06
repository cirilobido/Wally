package com.cirilobido.wally.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.cirilobido.wally.R
import com.cirilobido.wally.data.model.PhotoModel
import com.cirilobido.wally.databinding.ItemPhotoBinding

class SearchResultAdapter(private val photoList: List<PhotoModel>): RecyclerView.Adapter<SearchResultAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultAdapter.ViewHolder {
        var view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_search, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        itemPostition = position
        holder.bind(photoList[position])
    }

    override fun getItemCount(): Int = photoList.size

    companion object {
        private var itemPostition: Int = 0
        fun getItemPosition(): Int = itemPostition
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        private val binding = ItemPhotoBinding.bind(view)

        fun bind(photoModel: PhotoModel){
            with(binding) {
                if (getItemPosition() == 0){
                    imgItem.layoutParams.apply {
                        width = root.context.resources.getDimension(R.dimen._155sdp).toInt()
                        height = root.context.resources.getDimension(R.dimen._117sdp).toInt()
                    }
                }
                Glide.with(root.context)
                    .load(photoModel.photoResolutions.small)
                    .thumbnail(0.25f)
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                    .into(imgItem)
            }

        }
    }
}