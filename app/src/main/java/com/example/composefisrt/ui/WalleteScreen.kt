package com.example.composefisrt.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composefisrt.ui.theme.ComposeFirstTheme
import com.example.composefisrt.ui.wallet.ActionsSection
import com.example.composefisrt.ui.wallet.CardSection
import com.example.composefisrt.ui.wallet.SpendingGraph
import com.example.composefisrt.ui.wallet.SpendingSection
import com.example.composefisrt.ui.wallet.TopBar

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
        MainScreen(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        )
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        Spacer(modifier = Modifier.height(30.dp))
        CardSection(
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))
        ActionsSection(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(20.dp))
        SpendingSection(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(20.dp))
        SpendingGraph(modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(horizontal = 22.dp))
        Spacer(modifier = Modifier.height(40.dp))
    }

}


@Preview
@Composable
private fun WalletScreenPreview() {
    ComposeFirstTheme {
        WalletScreen()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun WalletScreenPreviewDark() {
    ComposeFirstTheme {
        WalletScreen()
    }
}