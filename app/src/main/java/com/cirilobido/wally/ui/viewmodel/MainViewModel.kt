package com.cirilobido.wally.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cirilobido.wally.data.model.ColorModel
import com.cirilobido.wally.data.model.PhotoModel
import com.cirilobido.wally.data.model.TopicModel
import com.cirilobido.wally.domain.GetColorsUseCase
import com.cirilobido.wally.domain.GetPopularPhotosUseCase
import com.cirilobido.wally.domain.GetTopicsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPopularPhotosUseCase: GetPopularPhotosUseCase,
    private val getColorsUseCase: GetColorsUseCase,
    private val getTopicsUseCase: GetTopicsUseCase): ViewModel() {

    var isLoading = MutableLiveData<Boolean>()
    var photoModelList = MutableLiveData<List<PhotoModel>?>()
    val colorModel = MutableLiveData<List<ColorModel>?>()
    var topicsList = MutableLiveData<List<TopicModel>?>()


    fun getData(){
        viewModelScope.launch {
            isLoading.postValue(true)
            getPhotos()
            getColors()
            getTopics()
        }
    }

    fun getPhotos(){
        viewModelScope.launch {
            val result: List<PhotoModel>? = getPopularPhotosUseCase()
            if (!result.isNullOrEmpty()){
                photoModelList.postValue(result)
                isLoading.postValue(false)
            }
        }
    }

    fun getColors(){
        viewModelScope.launch {
            val result: List<ColorModel>? = getColorsUseCase()
            if (!result.isNullOrEmpty()){
                colorModel.postValue(result)
            }
        }
    }

    fun getTopics(){
        viewModelScope.launch {
            var result: List<TopicModel>? = getTopicsUseCase()
            if (!result.isNullOrEmpty()){
                topicsList.postValue(result)
            }
        }
    }
}