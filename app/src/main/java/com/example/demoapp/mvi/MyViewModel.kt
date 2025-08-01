package com.example.demoapp.mvi

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 *
 * @ProjectName:  DemoApp
 * @Desc:
 * @Author:  YangShuang
 * @Date:  2024/6/17
 */
class MyViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun onEvent(event: UiEvent) {
        when (event) {
            is UiEvent.LoadData -> {
                _uiState.value = UiState(isLoading = true)
                // 模拟数据加载
                viewModelScope.launch {
                    delay(2000)
                    _uiState.value = UiState(data = "Hello, Compose with MVI!")
                }
            }

            is UiEvent.ShowData -> {
                _uiState.value = UiState(data = event.data)
            }

            is UiEvent.ShowError -> {
                _uiState.value = UiState(error = event.error)
            }
        }
    }
}