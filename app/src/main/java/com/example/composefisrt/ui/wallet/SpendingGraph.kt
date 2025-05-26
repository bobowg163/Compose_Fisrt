package com.example.composefisrt.ui.wallet

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composefisrt.R
import me.bytebeats.views.charts.bar.BarChart
import me.bytebeats.views.charts.bar.BarChartData
import me.bytebeats.views.charts.bar.render.label.SimpleLabelDrawer
import me.bytebeats.views.charts.bar.render.xaxis.SimpleXAxisDrawer
import me.bytebeats.views.charts.bar.render.yaxis.SimpleYAxisDrawer

/**
 * 项目名称：Compose Fisrt
 * 包名：com.example.composefisrt.ui.wallet
 * 日期：2025/5/26时间：19:58
 * 作者: bobowg
 * 备注：
 * 子界面

 **/
val spendingByDay = listOf(
    BarChartData.Bar(
        label = "Dec 1",
        value = 123f,
        color = randomColor(50)
    ),
    BarChartData.Bar(
        label = "Dec 2",
        value = 13f,
        color = randomColor(50)
    ),
    BarChartData.Bar(
        label = "Dec 3",
        value = 163f,
        color = randomColor(50)
    ),
    BarChartData.Bar(
        label = "Dec 4",
        value = 45f,
        color = randomColor(50)
    ),
    BarChartData.Bar(
        label = "Dec 5",
        value = 230f,
        color = randomColor(50)
    ),
    BarChartData.Bar(
        label = "Dec 6",
        value = 139f,
        color = randomColor(50)
    ),
    BarChartData.Bar(
        label = "Dec 7",
        value = 166f,
        color = randomColor(50)
    ),
)

@Preview(showBackground = true)
@Composable
fun SpendingGraph(
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = Modifier.padding(horizontal = 22.dp),
        text = "消费统计",
        fontFamily = Font(R.font.afw).toFontFamily(),
        fontSize = 25.sp,
    )
    Spacer(modifier = Modifier.height(16.dp))
    Chart(modifier = modifier)
}


@Composable
fun Chart(modifier: Modifier = Modifier) {
    BarChart(
        modifier = modifier,
        barChartData = BarChartData(spendingByDay),
        xAxisDrawer = SimpleXAxisDrawer(
            axisLineThickness = 2.dp,
            axisLineColor = MaterialTheme.colorScheme.onBackground.copy(0.2f)
        ),
        yAxisDrawer = SimpleYAxisDrawer(
            labelValueFormatter = {"$${it.toInt()}"},
            axisLineThickness = 2.dp,
            axisLineColor = MaterialTheme.colorScheme.onBackground.copy(0.2f)
        ),
        labelDrawer = SimpleLabelDrawer(
            drawLocation = SimpleLabelDrawer.DrawLocation.Outside,
            labelTextSize = 15.sp,

        )
    )
}

