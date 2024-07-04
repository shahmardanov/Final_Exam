package com.example.test.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.final_exam.model.ProductResponseItem
import com.example.test.api.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    private var _data = MutableLiveData<List<ProductResponseItem>>()
    val data: LiveData<List<ProductResponseItem>> get() = _data

    private var _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    fun getData() {
        _loading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = productRepository.getProduct()
                if (response.isSuccessful) {
                    Log.e("data", response.toString())
                    withContext(Dispatchers.Main) {
                        response.body()?.let {
                            if (it.isNotEmpty()) {
                                _data.value = it
                                _loading.value = false
                            }
                        }
                    }
                }
            } catch (e: Exception) {
                if (e.localizedMessage != null) {
                    Log.e("xeta", e.localizedMessage)
                }
            }
        }
    }

    fun addProduct(productResponse: ProductResponseItem){
        viewModelScope.launch(Dispatchers.IO) {
            productRepository.addProductsLocal(productResponse)
        }
    }



}