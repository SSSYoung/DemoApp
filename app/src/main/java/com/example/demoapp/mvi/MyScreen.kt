package com.example.demoapp.mvi

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
/**
 *
 * @ProjectName:  DemoApp
 * @Desc:
 * @Author:  YangShuang
 * @Date:  2024/6/17
 */
@Composable
fun MyScreen(viewModel: MyViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    when {
        uiState.isLoading -> {
            uiState.data?.let { Text(text = it) }
        }
        uiState.data != null -> {
            Text(text = uiState.data!!)
        }
        uiState.error != null -> {
            Text(text = uiState.error!!)
        }
        else -> {
            Button(onClick = { viewModel.onEvent(UiEvent.LoadData) }) {
                Text("Load Data")
            }
        }
    }
}
