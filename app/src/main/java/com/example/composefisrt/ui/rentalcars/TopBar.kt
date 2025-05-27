package com.example.composefisrt.ui.rentalcars

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Mic
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * 项目名称：Compose Fisrt
 * 包名：com.example.composefisrt.ui.rentalcars
 * 日期：2025/5/27时间：11:08
 * 作者: bobowg
 * 备注：


 **/


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior
) {
    TopAppBar(
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent,
            scrolledContainerColor = Color.Transparent
        ),
        title = {
            Row(
                modifier = Modifier
                    .padding(top = 16.dp, end = 16.dp)
                    .height(60.dp)
                    .border(width = 1.dp, color = Color.White, shape = RoundedCornerShape(100.dp))
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = null,
                    modifier= Modifier.size(28.dp),
                    tint = MaterialTheme.colorScheme.background
                )

                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "热门新车",
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.background,
                    modifier = Modifier.weight(1f)
                )

                Icon(
                    imageVector = Icons.Rounded.Mic,
                    contentDescription = null,
                    modifier= Modifier.size(28.dp),
                    tint = MaterialTheme.colorScheme.background
                )
            }
        }
    )
}