package com.example.fetchrewards

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.fetchrewards.network.dataModel
import com.example.fetchrewards.network.dataNetwork


class MainActivityViewModel : ViewModel() {
    val myResponseList: MutableLiveData<List<dataModel>> = MutableLiveData()
    fun getPosts() {
        viewModelScope.launch {
            myResponseList.value = dataNetwork.retrofit.getPosts()
        }
    }
}