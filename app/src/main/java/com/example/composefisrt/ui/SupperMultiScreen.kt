package com.example.composefisrt.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composefisrt.data.WindowType
import com.example.composefisrt.data.rememberWindowSize
import com.example.composefisrt.ui.theme.ComposeFirstTheme

/**
 * 项目名称：Compose Fisrt
 * 包名：com.example.composefisrt.ui
 * 日期：2025/5/21时间：11:18
 * 作者: bobowg
 * 备注：
 * 在 Jetpack Compose 中支持多种屏幕尺寸

 **/


@Composable
fun SupperMultiScreen() {
    val windowSize = rememberWindowSize()
    when (windowSize.width) {
        WindowType.Compact -> {
            CompactItemsScreen()
        }

        else -> {
            MediumToExpandedItemsScreen()
        }
    }
}


@Composable
fun CompactItemsScreen() {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(8) { index ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(16.dp)
                    .clip(
                        RoundedCornerShape(30.dp)
                    )
                    .background(MaterialTheme.colorScheme.secondaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "item $index",
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 30.sp,
                    fontStyle = FontStyle.Italic
                )
            }
        }
    }
}

@Composable
fun MediumToExpandedItemsScreen() {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Adaptive(250.dp)
    ) {
        items(8) { index ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(16.dp)
                    .clip(
                        RoundedCornerShape(30.dp)
                    )
                    .background(MaterialTheme.colorScheme.secondaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "item $index",
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Italic
                )
            }
        }
    }
}

@Composable
fun ProfilesScreen() {
    val windowSize = rememberWindowSize()
    when (windowSize.width) {
        WindowType.Compact -> {
            CompactProfileScreen()
        }

        else -> {
            MediumToExpandedProfileScreen()
        }
    }
}


@Composable
private fun CompactProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 32.dp)
    ) {
        Spacer(modifier = Modifier.height(36.dp))
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .size(180.dp)
                .background(
                    MaterialTheme.colorScheme.primary
                )
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "A",
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = 80.sp
            )
        }
        Spacer(modifier = Modifier.height(64.dp))
        UserInfo(
            title = "Name",
            content = "Ahmed Guedmioui"
        )
        UserInfo(
            title = "Email",
            content = "bobowg@explame.com"
        )
        UserInfo(
            title = "Gender",
            content = "Male \uD83E\uDDAC"
        )
    }
}

@Composable
private fun MediumToExpandedProfileScreen() {


        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.height(36.dp))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .size(180.dp)
                    .background(
                        MaterialTheme.colorScheme.primary
                    )
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = "A",
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 80.sp
                )
            }
            Spacer(modifier = Modifier.width(64.dp))
            Column {
                UserInfo(
                    title = "Name",
                    content = "Ahmed Guedmioui"
                )
                UserInfo(
                    title = "Email",
                    content = "bobowg@explame.com"
                )
                UserInfo(
                    title = "Gender",
                    content = "Male \uD83E\uDDAC"
                )
            }

        }

}

@Composable
private fun UserInfo(
    modifier: Modifier = Modifier,
    title:String,
    content: String
) {
    Column (
        modifier = modifier.fillMaxWidth()
    ){
        Text(
            text = title,
            color = MaterialTheme.colorScheme.secondaryContainer,
            fontSize = 38.sp
        )
        Text(
            text = content,
            color = MaterialTheme.colorScheme.primary,
            fontSize = 38.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Preview(widthDp = 600)
@Composable
private fun CompactMultiScreenPrview() {
    ComposeFirstTheme {
        SupperMultiScreen()
    }
}

@Preview(heightDp = 400, widthDp = 860)
@Composable
private fun MediumToExpandedItemsPreview() {
    ComposeFirstTheme {
        SupperMultiScreen()
    }
}

@Preview(widthDp = 600)
@Composable
private fun CompactProfilesScreenPrview() {
    ComposeFirstTheme {
        ProfilesScreen()
    }
}

@Preview(heightDp = 400, widthDp = 860)
@Composable
private fun MediumToExpandedProfilesScreenPreview() {
    ComposeFirstTheme {
        ProfilesScreen()
    }
}



