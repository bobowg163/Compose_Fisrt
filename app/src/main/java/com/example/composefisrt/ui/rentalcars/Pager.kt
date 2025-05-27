package com.example.composefisrt.ui.rentalcars

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composefisrt.ui.theme.Primary
import com.example.composefisrt.ui.theme.PurpleGrey40

/**
 * 项目名称：Compose Fisrt
 * 包名：com.example.composefisrt.ui.rentalcars
 * 日期：2025/5/27时间：12:42
 * 作者: bobowg
 * 备注：


 **/


@Composable
fun Pager(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "豪华\n租车",
            fontSize = 25.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onPrimary,
            lineHeight = 40.sp,
            modifier = Modifier.padding(horizontal = 22.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.padding(bottom = 10.dp),
        ) {
            Text(
                text = "豪华",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimary,
                lineHeight = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "VIP 租车",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimary,
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "新",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = PurpleGrey40,
                    modifier = Modifier
                        .alpha(0.7f)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Primary)
                        .padding(horizontal = 5.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            verticalAlignment = Alignment.Bottom
        ) {
            HorizontalDivider(
                modifier = Modifier.weight(1f),
                thickness = 3.dp,
                color = MaterialTheme.colorScheme.onSecondary
            )
            HorizontalDivider(
                modifier = Modifier.weight(1f),
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.onSecondary
            )
        }
    }
}