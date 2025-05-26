package com.example.composefisrt.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import com.example.composefisrt.ui.Wallet.TopBar
import com.example.composefisrt.ui.theme.ComposeFirstTheme

/**
 * 项目名称：Compose Fisrt
 * 包名：com.example.composefisrt.ui
 * 日期：2025/5/26时间：13:25
 * 作者: bobowg
 * 备注：导入包 compose-charts = {group="io.github.bytebeats",name="compose-charts",version.ref="composeCharts"}

 **/


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WalletScreen() {
    val scrollBehavior =
        TopAppBarDefaults.enterAlwaysScrollBehavior(state = rememberTopAppBarState())
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopBar(
                modifier = Modifier.fillMaxWidth(),
                scrollBehavior = scrollBehavior
            )
        },
    ) { paddingValues ->
        MainScreen(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues))
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {

}


@Preview
@Composable
private fun WalletScreenPreview() {
    ComposeFirstTheme {
        WalletScreen()
    }
}