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
import com.cirilobido.wally.data.model.TopicModel
import com.cirilobido.wally.databinding.ItemPhotoBinding
import com.cirilobido.wally.databinding.ItemTopicBinding

class TopicsAdapter(private val topicsList: List<TopicModel>): RecyclerView.Adapter<TopicsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicsAdapter.ViewHolder {
        var view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_topic, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopicsAdapter.ViewHolder, position: Int) {
        holder.bind(topicsList[position])
    }

    override fun getItemCount(): Int = topicsList.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        private val binding = ItemTopicBinding.bind(view)

        fun bind(topicsList: TopicModel){
            with(binding) {
                txtTopicName.text = topicsList.title
                txtTopicCount.text = "(${topicsList.total_photos.toString()})"
                Glide.with(binding.root.context)
                    .load(topicsList.coverPhoto.photoResolutions.small)
                    .thumbnail(0.25f)
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                    .into(imgItem)
            }

        }
    }
}