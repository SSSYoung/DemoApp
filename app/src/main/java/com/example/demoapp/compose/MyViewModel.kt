package com.example.demoapp.compose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 *
 * @ProjectName:  DemoApp
 * @Desc:
 * @Author:  YangShuang
 * @Date:  2024/6/17
 */
class MyViewModel:ViewModel() {
    private val _uiState = MutableStateFlow("Initial State")
    val uiState: StateFlow<String> get() = _uiState

    fun updateUI(newState: String) {
        viewModelScope.launch {
            _uiState.value = newState
        }
    }
}