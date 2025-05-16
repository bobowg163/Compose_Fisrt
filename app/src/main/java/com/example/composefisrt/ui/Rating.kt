package com.example.composefisrt.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material.icons.rounded.StarOutline
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composefisrt.ui.theme.ComposeFirstTheme

/**
 * 项目名称：Compose Fisrt
 * 包名：com.example.composefisrt.ui
 * 日期：2025/5/16时间：11:07
 * 作者: bobowg
 * 备注： 评星示例


 **/

@Composable
fun RatingScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var rating1 by remember { mutableDoubleStateOf(3.5) }
        var rating2 by remember { mutableDoubleStateOf(3.5) }
        var rating3 by remember { mutableDoubleStateOf(3.5) }
        RatingBar(
            modifier = Modifier.size(50.dp),
            rating = rating1,
            startColor = Color.Green
        ) {
            rating1 = it
        }
        RatingBar(
            modifier = Modifier.size(40.dp),
            rating = rating2,
            start = 6,
        ) {
            rating2 = it
        }
        RatingBar(
            modifier = Modifier.size(50.dp),
            rating = rating3,
            startColor = Color.Green
        ) {
            rating3 = it
        }
    }
}

@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    rating: Double = 0.0,
    start: Int = 5,
    startColor: Color = Color.Yellow,
    onRatingChange: (Double) -> Unit
) {
    var isHalfStar = (rating % 1) != 0.0
    Row {
        for (index in 1..start) {
            Icon(
                modifier = modifier.clickable { onRatingChange(index.toDouble()) },
                imageVector = if (index <= rating) {
                    Icons.Rounded.Star
                } else {
                    if (isHalfStar) {
                        isHalfStar = false
                        Icons.Rounded.StarHalf
                    } else {
                        Icons.Rounded.StarOutline
                    }
                },
                contentDescription = null,
                tint = startColor
            )
        }
    }
}

@Preview
@Composable
private fun RatingBarPreview() {
    ComposeFirstTheme {
        RatingBar(
            rating = 0.5,
            start = 3,
            onRatingChange = {

            }
        )
    }
}


