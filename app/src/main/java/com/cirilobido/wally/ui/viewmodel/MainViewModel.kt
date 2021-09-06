package com.cirilobido.wally.ui.viewmodel

import android.os.CountDownTimer
import android.util.Log
import androidx.core.view.isVisible
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cirilobido.wally.data.model.ColorModel
import com.cirilobido.wally.data.model.PhotoModel
import com.cirilobido.wally.data.model.SearchResultModel
import com.cirilobido.wally.data.model.TopicModel
import com.cirilobido.wally.domain.GetColorsUseCase
import com.cirilobido.wally.domain.GetPopularPhotosUseCase
import com.cirilobido.wally.domain.GetSearchResultUseCase
import com.cirilobido.wally.domain.GetTopicsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flow
import okhttp3.internal.wait
import org.w3c.dom.ls.LSException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPopularPhotosUseCase: GetPopularPhotosUseCase,
    private val getColorsUseCase: GetColorsUseCase,
    private val getTopicsUseCase: GetTopicsUseCase,
    private val getSearchResultUseCase: GetSearchResultUseCase): ViewModel() {

    var isLoadingData = MutableLiveData<Boolean>()
    var isLoadingSearch = MutableLiveData<Boolean>()
    val colorModel = MutableLiveData<List<ColorModel>?>()
    var photoModelList = MutableLiveData<List<PhotoModel>?>()
    var topicsList = MutableLiveData<List<TopicModel>?>()
    var searchList = MutableLiveData<SearchResultModel?>()


    fun getData(){
        viewModelScope.launch {
            isLoadingData.postValue(true)
            supervisorScope {
                getPhotos()
                getColors()
                getTopics()
            }
        }
    }

    private suspend fun setIsLoading(){
        if (photoModelList.value.isNullOrEmpty()
            && colorModel.value.isNullOrEmpty()
            && topicsList.value.isNullOrEmpty()){
            isLoadingData.postValue(true)
        } else {
            delay(2000)
            isLoadingData.postValue(false)
        }
    }

    private fun getPhotos(){
        viewModelScope.launch {
            val result: List<PhotoModel>? = getPopularPhotosUseCase()
            if (!result.isNullOrEmpty()){
                photoModelList.postValue(result)
            }
            setIsLoading()
        }
    }

    private fun getColors(){
        viewModelScope.launch {
            val result: List<ColorModel>? = getColorsUseCase()
            if (!result.isNullOrEmpty()){
                colorModel.postValue(result)
            }
            setIsLoading()
        }
    }

    private fun getTopics(){
        viewModelScope.launch {
            var result: List<TopicModel>? = getTopicsUseCase()
            if (!result.isNullOrEmpty()){
                topicsList.postValue(result)
            }
            setIsLoading()
        }
    }

    fun getSearch(page: Int, queryParams: String, color: String?){
        viewModelScope.launch {
            isLoadingSearch.postValue(true)
            val result: SearchResultModel? = getSearchResultUseCase(page, queryParams, color)
            if (result?.total!! > 0){
                searchList.postValue(result)
            }
            isLoadingSearch.postValue(false)
        }
    }
}