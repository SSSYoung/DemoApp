package com.example.demoapp.gpu

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GpuSettingViewModel: ViewModel() {
    val para1 = MutableLiveData<Int>()
    val para2 = MutableLiveData<Int>()
    val para3 = MutableLiveData<Int>()
    val para4 = MutableLiveData<Int>()

    fun setParams(p1:Int,p2:Int,p3:Int,p4:Int) {
        para1.value = p1
        para2.value = p2
        para3.value = p3
        para4.value = p4
    }

    fun postParams(p1:Int,p2:Int,p3:Int,p4:Int) {
        para1.postValue(p1)
        para2.postValue(p2)
        para3.postValue(p3)
        para4.postValue(p4)
    }
}