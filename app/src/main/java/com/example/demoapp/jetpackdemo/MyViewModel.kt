package com.example.demoapp.jetpackdemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.launch

class MyViewModel: ViewModel() {
    private val testLiveData = MutableLiveData<Int>()
    private var i = 0

    fun getTestNum() = testLiveData

    fun plusOne() {
        i++
        testLiveData.value = i
    }
}