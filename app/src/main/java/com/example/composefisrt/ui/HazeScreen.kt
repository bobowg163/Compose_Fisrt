package com.example.composefisrt.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composefisrt.data.luxuriousCars
import com.example.composefisrt.ui.rentalcars.CarItem
import com.example.composefisrt.ui.rentalcars.Pager
import dev.chrisbanes.haze.hazeEffect
import dev.chrisbanes.haze.hazeSource
import dev.chrisbanes.haze.materials.ExperimentalHazeMaterialsApi
import dev.chrisbanes.haze.rememberHazeState

/*
* 项目名称: Compose Fisrt
* 包名: com.example.composefisrt.ui
* 日期: 2025/5/29 时间: 07:31
* 作者: bobowg
* 备注：
*/

@OptIn(ExperimentalMaterial3Api::class, ExperimentalHazeMaterialsApi::class)
@Preview
@Composable
fun HazeScreen() {
    val hazeState = rememberHazeState()
    Box {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .hazeSource(state = hazeState, zIndex = 0f)
        ) {
            itemsIndexed(luxuriousCars) { index, car ->
                CarItem(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .height(230.dp)
                        .hazeSource(state = hazeState, zIndex = (index + 1).toFloat()),
                    car = car
                )
            }
        }
    }
    LargeTopAppBar(
        // Need to make app bar transparent to see the content behind
        colors = TopAppBarDefaults.largeTopAppBarColors(Color.Transparent),
        modifier = Modifier
            .hazeEffect(state = hazeState)
            .fillMaxWidth(),
        title = {
            Pager()
        }
    )

}