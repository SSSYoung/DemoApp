package com.example.demoapp.compose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Space
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demoapp.R

class ComposeActivity : AppCompatActivity() {
    private val viewModel: MyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //PhotographerCard()
            //SimpleColumn()
            //ScrollColume()
            //ScrollingList()
            Column {
                Spacer(modifier = Modifier.height(20.dp))
                Button(onClick = { viewModel.updateUI("yangshuang") }) {
                    Text("yangshuang Change State")
                }
                Spacer(modifier = Modifier.height(20.dp))
                MyComposable(viewModel = viewModel)
            }

        }
    }

    @Preview
    @Composable
    fun Hello() {
        Column {
            Text(text = "click")
            Spacer(modifier = Modifier.height(20.dp))
            MyComposable(viewModel = viewModel)
        }
    }
}