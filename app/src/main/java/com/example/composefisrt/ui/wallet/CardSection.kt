package com.example.composefisrt.ui.wallet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterBAndW
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composefisrt.R

/**
 * 项目名称：Compose Fisrt
 * 包名：com.example.composefisrt.ui.Wallet
 * 日期：2025/5/26时间：14:01
 * 作者: bobowg
 * 备注：
 * 主界面
 **/

@Composable
fun CardSection(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
                .height(100.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(brush = Brush.horizontalGradient(listOf(Color.Green, Color.Yellow)))
        )

        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
                .padding(horizontal = 22.dp, vertical = 10.dp),
            elevation = CardDefaults.cardElevation(6.dp),
            shape = RoundedCornerShape(20.dp)
        ) {
            CardContent(modifier = Modifier.fillMaxSize())
        }
    }
}

@Composable
fun CardContent(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.background(
            brush = Brush.linearGradient(
                listOf(
                    MaterialTheme.colorScheme.primary,
                    MaterialTheme.colorScheme.error
                ),
            )
        )
    ) {
        Icon(
            modifier = Modifier
                .size(120.dp)
                .offset(230.dp, 100.dp),
            imageVector = ImageVector.vectorResource(R.drawable.fontward),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.background.copy(0.1f)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(22.dp)
                .align(Alignment.TopCenter),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(8.dp))
            Text(
                text = "我的银行",
                color = MaterialTheme.colorScheme.onPrimary.copy(0.6f),
                fontFamily = Font(R.font.afw).toFontFamily(),
                fontSize = 22.sp
            )
            Spacer(modifier = Modifier.height(18.dp))
            Text(
                text = "$4.520.00",
                color = MaterialTheme.colorScheme.onPrimary,
                fontFamily = Font(R.font.afw).toFontFamily(),
                fontSize = 36.sp
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(22.dp)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = "*** *** 3132",
                color = MaterialTheme.colorScheme.onPrimary.copy(0.8f),
                fontSize = 23.sp,
                fontFamily = Font(R.font.afw).toFontFamily()

            )
            Icon(
                modifier = Modifier.width(60.dp).size(60.dp),
                imageVector = Icons.Default.FilterBAndW,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.background
            )

        }
    }
}

