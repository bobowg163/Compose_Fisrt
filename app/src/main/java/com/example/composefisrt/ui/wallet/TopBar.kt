package com.example.composefisrt.ui.wallet

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composefisrt.R

/**
 * 项目名称：Compose Fisrt
 * 包名：com.example.composefisrt.ui.Wallet
 * 日期：2025/5/26时间：13:32
 * 作者: bobowg
 * 备注：
 * 财理顶状态

 **/

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior
) {
    TopAppBar(
        title = {
            Box(modifier = modifier.padding(end = 20.dp)) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(40.dp)
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .align(Alignment.CenterStart)
                )
                Text(
                    text = "钱包",
                    fontSize = 40.sp,
                    fontFamily = Font(R.font.afw).toFontFamily(),
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier
                        .padding(12.dp)
                        .align(Alignment.CenterStart)
                )
                Image(
                    painter = painterResource(R.drawable.mht),
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .align(Alignment.CenterEnd)
                )
            }
        },
        scrollBehavior = scrollBehavior,
        modifier = modifier
    )
}