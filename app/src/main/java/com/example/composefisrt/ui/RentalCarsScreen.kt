package com.example.composefisrt.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composefisrt.ui.rentalcars.BottomBar
import com.example.composefisrt.ui.rentalcars.CarList
import com.example.composefisrt.ui.rentalcars.Pager
import com.example.composefisrt.ui.rentalcars.TopBar
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.hazeEffect
import dev.chrisbanes.haze.hazeSource

/**
 * 项目名称：Compose Fisrt
 * 包名：com.example.composefisrt.ui
 * 日期：2025/5/27时间：09:43
 * 作者: bobowg
 * 备注：
 * 导入包 haze = {module="dev.chrisbanes.haze:haze",version.ref="haze"}
 * haze用法见：https://chrisbanes.github.io/haze/latest/usage/

 **/


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun RentalCarsScreen() {
    val hazeState = remember { HazeState() }
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = rememberTopAppBarState()
    )
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection)
            .background(MaterialTheme.colorScheme.secondaryContainer),
        containerColor = Color.Transparent,
        topBar = {
            Column {
                TopBar(
                    modifier = Modifier.hazeEffect(
                        state = hazeState,
                    ),
                    scrollBehavior = scrollBehavior
                )
                Pager(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, start = 8.dp, end = 8.dp)
                        .hazeEffect(
                            state = hazeState,
                        )
                )
            }
        },
    ) { innerPadding ->
        HomeScreen(
            modifier = Modifier
                .fillMaxSize(),
            hazeState = hazeState,
            paddingValues = innerPadding
        )
    }
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    hazeState: HazeState,
    paddingValues: PaddingValues
) {
    Box(
        modifier = modifier.background(MaterialTheme.colorScheme.background)
    ) {
        CarList(
            modifier = Modifier
                .fillMaxSize()
                .hazeSource(state = hazeState, 0f),
            paddingValues = paddingValues
        )
        BottomBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp)
                .align(alignment = Alignment.BottomStart)
                .padding(bottom = 26.dp)
                .hazeEffect(state = hazeState)
        )
    }
}
