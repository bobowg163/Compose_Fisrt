package com.example.composefisrt.data

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator

/**
 * 项目名称：Compose Fisrt
 * 包名：com.example.composefisrt.data
 * 日期：2025/5/14时间：23:05
 * 作者: bobowg
 * 备注：Voyager屏幕导航
 * 总共3个屏幕，着个导航。

 **/


 class VoyagerScreen1 : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Screen 1")
            Spacer(modifier = Modifier.height(50.dp))
            Button(
                onClick = {
                    navigator?.push(VoyagerScreen2("hell world!"))
                }
            ) {
                Text(text = "Go to Screen 2")
            }
        }
    }
}

data class VoyagerScreen2(
    val text: String
) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Screen 2 $text")
            Spacer(modifier = Modifier.height(50.dp))
            Button(
                onClick = {
                    navigator?.push(VoyagerScreen3())
                }
            ) {
                Text(text = "Go to Screen 3")
            }
        }
    }
}

class VoyagerScreen3 : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Screen 3")
            Spacer(modifier = Modifier.height(50.dp))
            Button(
                onClick = {
                    navigator?.pop()
                }
            ) {
                Text(text = "Go back")
            }
        }
    }
}