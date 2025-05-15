package com.example.composefisrt.data

import androidx.annotation.DrawableRes
import com.example.composefisrt.R

data class Item(
    val title: String,
    @DrawableRes val image: Int,
)


val item:List<Item> = listOf(
    Item("Item 1", R.drawable.mhm),
    Item("Item 2", R.drawable.mht),
    Item("Item 3", R.drawable.mhm1),
    Item("Item 5", R.drawable.mhm),
    Item("Item 6", R.drawable.mhm1),
    Item("Item 7", R.drawable.mht),
    Item("Item 4", R.drawable.mhm1),
    Item("Item 8", R.drawable.mht),
    Item("Item 9", R.drawable.mhm),
)