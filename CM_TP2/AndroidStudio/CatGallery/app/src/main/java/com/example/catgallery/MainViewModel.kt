package com.example.catgallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catgallery.model.CatImage
import com.example.catgallery.network.RetrofitInstance
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _catImages = MutableLiveData<List<CatImage>>()
    val catImages: LiveData<List<CatImage>> get() = _catImages

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> get() = _errorMessage

    fun loadCatImages() {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null
            try {
                val response = RetrofitInstance.api.getImages(System.currentTimeMillis())
                _catImages.value = response
            } catch (e: Exception) {
                e.printStackTrace()
                _errorMessage.value = e.message ?: "Unknown error"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
