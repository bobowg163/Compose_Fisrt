package com.example.composefisrt.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composefisrt.ui.theme.ComposeFirstTheme

/**
 * 项目名称：Compose Fisrt
 * 包名：com.example.composefisrt.ui
 * 日期：2025/5/6时间：21:22
 * 作者: bobowg
 * 备注：导航示例图
 *
 **/


@Composable
fun NavigateExample() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = "home",
            contentAlignment = Alignment.Center
        ) {
            composable("home") {
                FirstScreen(navController = navController)
            }
            composable(
                "second/{url}",
                arguments = listOf(
                    navArgument(name = "url") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                SecondScreen(
                    navController = navController,
                    backStackEntry = backStackEntry
                )
            }
        }
    }
}

@Composable
fun FirstScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Home Screen",
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigate("second"+"/www.bobowg.com")
        }) {
            Text(
                text = "go to second Screen",
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun SecondScreen(
    navController: NavHostController,
    backStackEntry: NavBackStackEntry
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val url = backStackEntry.arguments?.getString("url")
        Text(
            text = "Second Screen - $url",
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigate("home")
        }) {
            Text(
                text = "go to back",
                fontSize = 20.sp
            )
        }
    }
}


@Preview
@Composable
private fun NavigateExamplePreview() {
    ComposeFirstTheme {
        NavigateExample()
    }
}