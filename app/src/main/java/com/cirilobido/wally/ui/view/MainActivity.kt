package com.cirilobido.wally.ui.view

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.cirilobido.wally.R
import com.cirilobido.wally.data.model.PhotoModel
import com.cirilobido.wally.databinding.ActivityMainBinding
import com.cirilobido.wally.ui.adapters.ColorsAdapter
import com.cirilobido.wally.ui.adapters.PhotosAdapter
import com.cirilobido.wally.ui.adapters.SearchResultAdapter
import com.cirilobido.wally.ui.adapters.TopicsAdapter
import com.cirilobido.wally.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.coroutineScope

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var colorsAdapter: ColorsAdapter
    private lateinit var popularPhotosAdapter: PhotosAdapter
    private lateinit var topicsAdapter: TopicsAdapter
    private lateinit var searchResultAdapter: SearchResultAdapter

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initObservers()
        initListeners()
    }

    private fun initListeners() {
        binding.btnSearch.setOnClickListener {
            if (!binding.editTextSearch.text.isNullOrBlank()) {
                binding.searchContainer.isVisible = true
                  mainViewModel.getSearch(1, binding.editTextSearch.text.toString(), null)
            } else {
                Toast.makeText(this, getString(R.string.search_empty), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initObservers(){
        val context = this
        with(binding) {
            mainViewModel.photoModelList.observe(context, Observer {photos ->
                popularPhotosAdapter = PhotosAdapter(photos!!)
                rvPopular.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                rvPopular.adapter = popularPhotosAdapter
            })

            mainViewModel.colorModel.observe(context, Observer {colors ->
                colorsAdapter = ColorsAdapter(colors!!);
                rvColor.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                rvColor.adapter = colorsAdapter
            })

            mainViewModel.topicsList.observe(context, Observer {topics ->
                topicsAdapter = TopicsAdapter(topics!!);
                rvCategories.layoutManager = GridLayoutManager(context, 2)
                rvCategories.adapter = topicsAdapter
            })

            mainViewModel.searchList.observe(context, Observer { search ->
                searchResultAdapter = SearchResultAdapter(search?.results!!)
                rvSearchResults.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                rvSearchResults.adapter = searchResultAdapter
            })

            mainViewModel.isLoadingData.observe(context, Observer {
                loadingContainer.isVisible = it
                searchContainer.isVisible = false
                homeDataContainer.isVisible = true

            })

            mainViewModel.isLoadingSearch.observe(context, Observer {
                loadingContainer.isVisible = it
                homeDataContainer.isVisible = false
                searchContainer.isVisible = true
            })

            mainViewModel.getData()
        }
    }
}