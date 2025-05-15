package com.example.composefisrt.ui

import android.app.Activity
import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun ProfileScreen() {
    val active = LocalActivity.current
    val windowSizeClass = calculateWindowSizeClass(activity = active as Activity)
    ScreenClass(windowSize = windowSizeClass)
}

@Composable
fun ScreenClass(windowSize: WindowSizeClass) {
    when (windowSize.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            MySmallScreen()
        }

        WindowWidthSizeClass.Expanded -> {
            MyExpandedScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyExpandedScreen() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "I'm ExPand windows")
    }

}

@Preview(showBackground = true)
@Composable
fun MySmallScreen() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "I'm Small windows")
    }
}
