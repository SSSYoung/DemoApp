package com.example.demoapp.mvi

/**
 *
 *
 * @ProjectName:  DemoApp
 * @Desc:
 * @Author:  YangShuang
 * @Date:  2024/6/17
 */
data class UiState(
    val isLoading: Boolean = false,
    val data: String? = null,
    val error: String? = null
)