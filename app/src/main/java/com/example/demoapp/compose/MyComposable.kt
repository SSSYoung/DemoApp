package com.example.demoapp.compose
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

/**
 *
 * @ProjectName:  DemoApp
 * @Desc:
 * @Author:  YangShuang
 * @Date:  2024/6/17
 */
@Composable
fun MyComposable(viewModel: MyViewModel = viewModel()) {
    // 使用collectAsState()来观察StateFlow的变化
    val uiState by viewModel.uiState.collectAsState()

    Column {
        Text(text = uiState)
        Button(onClick = { viewModel.updateUI("New State") }) {
            Text("Change State")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyComposablePreview() {
    MyComposable()
}