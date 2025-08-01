package com.example.demoapp.mvi

/**
 *
 * @ProjectName:  DemoApp
 * @Desc:
 * @Author:  YangShuang
 * @Date:  2024/6/17
 */
sealed class UiEvent {
    object LoadData : UiEvent()
    data class ShowData(val data: String) : UiEvent()

    data class ShowError(val error: String) : UiEvent()
}