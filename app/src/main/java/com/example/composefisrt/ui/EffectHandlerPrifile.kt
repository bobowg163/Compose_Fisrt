package com.example.composefisrt.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composefisrt.viewmodel.MyViewModel

/**
 *项目名称：Compose Fisrt
 *包名： com.example.composefisrt.ui
 *作者： bobowg
 *日期： 2025/5/4 时间：11:56
 *备注：
 **/

@Preview(showBackground = true)
@Composable
fun MyViewModelScreen(
    myViewModel: MyViewModel = viewModel()
) {
    val state = myViewModel.nameState.collectAsState()
    myViewModel.loadName()
    LaunchedEffect(true) {
        myViewModel.loadName()
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = state.value)
        Button(
            onClick = {
                myViewModel.addToName()
            }
        ) {
            Text(text = "Click me")
        }
    }

}
