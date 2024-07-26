package com.example.test.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.final_exam.model.CoffeeItem
import com.example.final_exam.model.ProductResponse
import com.example.final_exam.model.ProductResponseItem
import com.example.test.api.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavViewModel @Inject constructor(val repository: ProductRepository) : ViewModel() {

    val favList = MutableLiveData<List<CoffeeItem>>()

    fun getLocalProduct() {
        viewModelScope.launch {
            repository.getAllProductsLocal().collectLatest { data ->
                favList.value = data
            }
        }
    }
}