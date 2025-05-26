package com.example.composefisrt.ui.wallet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.DirectionsRun
import androidx.compose.material.icons.rounded.Restaurant
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material.icons.rounded.Superscript
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composefisrt.R
import com.example.composefisrt.ui.theme.ComposeFirstTheme
import kotlin.random.Random

/**
 * 项目名称：Compose Fisrt
 * 包名：com.example.composefisrt.ui.wallet
 * 日期：2025/5/26时间：17:44
 * 作者: bobowg
 * 备注：
 * 子界面
 **/

val spendingItems = listOf(
    SpendingItem(
        name = "食物",
        amount = 123f,
        color = randomColor(),
        icon = Icons.Rounded.Restaurant
    ),
    SpendingItem(
        name = "购物",
        amount = 166f,
        color = randomColor(),
        icon = Icons.Rounded.ShoppingCart
    ),
    SpendingItem(
        name = "订阅",
        amount = 230f,
        color = randomColor(),
        icon = Icons.Rounded.Superscript
    ),
    SpendingItem(
        name = "健康",
        amount = 520f,
        color = randomColor(),
        icon = Icons.AutoMirrored.Rounded.DirectionsRun
    ),

    )

@Composable
fun SpendingSection(modifier: Modifier = Modifier) {
    Text(
        modifier = Modifier.padding(horizontal = 22.dp),
        text = "支出明细",
        fontFamily = Font(R.font.afw).toFontFamily(),
        fontSize = 25.sp,
    )
    Spacer(modifier = Modifier.height(16.dp))
    SpendingList(modifier = modifier)
}

@Composable
fun SpendingList(modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)
    ) {
        itemsIndexed(spendingItems) { index, spendItem ->
            SpendingItem(spendingItem = spendItem)
            Spacer(modifier = Modifier.width(16.dp))

        }
    }
}

@Composable
fun SpendingItem(
    modifier: Modifier = Modifier,
    spendingItem: SpendingItem
) {
    ElevatedCard(
        modifier = modifier.size(150.dp),
        shape = RoundedCornerShape(20.dp),

        ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .background(spendingItem.color.copy(0.5f))
                .padding(20.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = spendingItem.icon,
                contentDescription = spendingItem.name,
                tint = MaterialTheme.colorScheme.secondary.copy(0.8f),
                modifier = Modifier.size(33.dp)
            )
            Text(
                text = spendingItem.name,
                fontFamily = Font(R.font.afw).toFontFamily(),
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.secondary.copy(0.8f)
            )
            Text(
                text = "$" + spendingItem.amount.toString(),
                fontFamily = Font(R.font.afw).toFontFamily(),
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}


fun randomColor(minBrightness: Int = 80): Color {
    val random = Random.Default
    val red = random.nextInt(minBrightness, 256)
    val green = random.nextInt(minBrightness, 256)
    val blue = random.nextInt(minBrightness, 256)
    return Color(red, green, blue)
}


data class SpendingItem(
    val name: String,
    val amount: Float,
    val color: Color,
    val icon: ImageVector
)

@Preview
@Composable
private fun SpendingSectionPreview() {
    ComposeFirstTheme {
        SpendingSection()
    }
}