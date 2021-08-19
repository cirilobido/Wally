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
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    val colorModel = MutableLiveData<List<ColorModel>?>()
    private var getColorUserCase = GetColorsUseCase()

    var photoModelList = MutableLiveData<List<PhotoModel>?>()
    private val getPopularPhotosUseCase = GetPopularPhotosUseCase()

    var topicsList = MutableLiveData<List<TopicModel>?>()
    private val  getTopicsUseCase = GetTopicsUseCase()

    fun getColors(){
        viewModelScope.launch {
            val result: List<ColorModel>? = getColorUserCase()
            if (!result.isNullOrEmpty()){
                colorModel.postValue(result)
            }
        }
    }

    fun getPhotos(){
        viewModelScope.launch {
            val result: List<PhotoModel>? = getPopularPhotosUseCase()
            if (!result.isNullOrEmpty()){
                photoModelList.postValue(result)
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