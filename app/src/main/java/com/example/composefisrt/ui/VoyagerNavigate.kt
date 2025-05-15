package com.example.composefisrt.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.example.composefisrt.data.AccountTab
import com.example.composefisrt.data.HomeTab

/**
 * 项目名称：Compose Fisrt
 * 包名：com.example.composefisrt.ui
 * 日期：2025/5/14时间：13:59
 * 作者: bobowg
 * 备注：Voyager 导航工具，比GOOGLE的导航要简单多了。

 **/

@Preview
@Composable
fun VoyagerNavigate() {
    TabNavigator(HomeTab) {
        Scaffold(
            bottomBar = {
                NavigationBar {
                    TabNavigationItem(tab = HomeTab)
                    TabNavigationItem(tab = AccountTab)
                }
            }
        ) {
            Box(modifier = Modifier.padding(bottom = it.calculateBottomPadding())){
                CurrentTab()
            }
        }
    }
}

@Composable
private fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current
    NavigationBarItem(
        selected = tabNavigator.current == tab,
        onClick = {
            tabNavigator.current = tab
        },
        icon = {
            tab.options.icon?.let { Icon(it, contentDescription = tab.options.title) }
        },
        label = {
            Text(text = tab.options.title)
        }
    )
}

