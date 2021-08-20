package com.cirilobido.wally.ui.view

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.cirilobido.wally.databinding.ActivityMainBinding
import com.cirilobido.wally.ui.adapters.ColorsAdapter
import com.cirilobido.wally.ui.adapters.PhotosAdapter
import com.cirilobido.wally.ui.adapters.TopicsAdapter
import com.cirilobido.wally.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var colorsAdapter: ColorsAdapter
    private lateinit var popularPhotosAdapter: PhotosAdapter
    private lateinit var topicsAdapter: TopicsAdapter

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val context = this
        with(binding) {
            mainViewModel.getData()
//            mainViewModel.getPhotos()
            mainViewModel.photoModelList.observe(context, Observer {photos ->
                popularPhotosAdapter = PhotosAdapter(photos!!)
                rvPopular.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                rvPopular.adapter = popularPhotosAdapter
            })

//            mainViewModel.getColors()
            mainViewModel.colorModel.observe(context, Observer {colors ->
                colorsAdapter = ColorsAdapter(colors!!);
                rvColor.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                rvColor.adapter = colorsAdapter
            })

//            mainViewModel.getTopics()
            mainViewModel.topicsList.observe(context, Observer {topics ->
                topicsAdapter = TopicsAdapter(topics!!);
                rvCategories.layoutManager = GridLayoutManager(context, 2)
                rvCategories.adapter = topicsAdapter
            })

            mainViewModel.isLoading.observe(context, Observer {
                loadingContainer.isVisible = it
                homeDataContainer.isVisible = !it
            })
        }

    }
}