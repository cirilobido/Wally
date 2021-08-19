package com.cirilobido.wally.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.cirilobido.wally.R
import com.cirilobido.wally.data.model.PhotoModel
import com.cirilobido.wally.data.model.PhotoResolutionModel
import com.cirilobido.wally.databinding.ItemPhotoBinding

class PhotosAdapter(private val photoList: List<PhotoModel>): RecyclerView.Adapter<PhotosAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosAdapter.ViewHolder {
        var view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_photo, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotosAdapter.ViewHolder, position: Int) {
        holder.bind(photoList[position])
    }

    override fun getItemCount(): Int = photoList.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        private val binding = ItemPhotoBinding.bind(view)

        fun bind(photoModel: PhotoModel){
            with(binding) {
                Glide.with(binding.root.context)
                    .load(photoModel.photoResolutions.small)
                    .thumbnail(0.25f)
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                    .into(binding.imgItem)
            }

        }
    }
}