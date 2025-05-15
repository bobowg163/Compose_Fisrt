package com.example.composefisrt.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * 项目名称：Compose Fisrt
 * 包名：com.example.composefisrt.ui
 * 日期：2025/5/6时间：15:29
 * 作者: bobowg
 * 备注：许多应用都需要能够精确控制屏幕上所绘制的内容。这种控制有可能只是将方框或圆形放到屏幕上的正确位置，
 * 也有可能是精心布置许多不同样式的图形元素。
 **/

@Preview
@Composable
fun CanvasExample() {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        val width = size.width
        val height = size.height
        val rewidth = 80.dp.toPx()
        val reheight = 80.dp.toPx()
        drawRect(
            color = Color.Yellow,
            size = Size(rewidth, reheight),
            topLeft = Offset(width / 2, height / 2)
        )
    }
}

@Preview
@Composable
private fun CanvasDrawLineExample() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        drawLine(
            start = Offset(x = canvasWidth, y = 0f),
            end = Offset(x = 0f, y = canvasHeight),
            strokeWidth = 12f,
            color = Color.Yellow
        )
    }
}

@Preview
@Composable
private fun CanvasDrawCircleExample() {
    Canvas(modifier = Modifier.fillMaxSize()) {

        translate(left = 90f, top = 100f) {
            drawCircle(Color.Blue, radius = 100.dp.toPx())
        }
    }
}

@Preview
@Composable
private fun CanvasDrawRectExample() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        rotate(degrees = 45f) {
            drawRect(
                Color.Blue,
                topLeft = Offset(x = size.width / 2f, y = size.height / 2f),
                size = size / 4f
            )
        }
    }
}