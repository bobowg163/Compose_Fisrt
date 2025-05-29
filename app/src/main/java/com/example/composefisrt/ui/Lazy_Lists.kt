package com.example.composefisrt.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.composefisrt.data.Item
import com.example.composefisrt.data.item
import com.example.composefisrt.ui.theme.ComposeFirstTheme

@Composable
fun HomeScreen(
    navHostController: NavHostController
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        item {
            Button(onClick = {
                navHostController.navigate("lazy_row_screen")
            }) {
                Text(text = "Lazy Row")
            }
        }

        item {
            Button(onClick = {
                navHostController.navigate("lazy_column_screen")
            }) {
                Text(text = "Lazy Column")
            }
        }
        item {
            Button(onClick = {
                navHostController.navigate("youtube_screen")
            }) {
                Text(text = "Lazy Grid")
            }
        }

        item {
            Button(onClick = {
                navHostController.navigate("scaffold_bottom")
            }) {
                Text(text = "Scaffold Bottom")
            }
        }

        item {
            Button(onClick = {
                navHostController.navigate("window_size_screen")
            }) {
                Text(text = "WindowsSizeScreen")
            }
        }
        item {
            Button(onClick = {
                navHostController.navigate("my_viewmodel")
            }) {
                Text(text = "MyViewModel")
            }
        }
        item {
            Button(onClick = {
                navHostController.navigate("animation_screen")
            }) {
                Text(text = "Animation")
            }
        }
        item {
            Button(onClick = {
                navHostController.navigate("canvas_screen")
            }) {
                Text(text = "Canvas")
            }
        }
        item {
            Button(onClick = {
                navHostController.navigate("navigate_screen")
            }) {
                Text(text = "NavigateScreen")
            }
        }
        item {
            Button(onClick = {
                navHostController.navigate("media3_screen")
            }) {
                Text(text = "Media3 ExPlay")
            }
        }
        item {
            Button(onClick = {
                navHostController.navigate("voyager_screen")
            }) {
                Text(text = "Voyager Navigate")
            }
        }
        item {
            Button(onClick = {
                navHostController.navigate("rating_screen")
            }) {
                Text(text = "Rating")
            }
        }
        item {
            Button(onClick = {
                navHostController.navigate("youtube_screen")
            }) {
                Text(text = "Play youtube and local media")
            }
        }
        item {
            Button(onClick = {
                navHostController.navigate("supportmulti_screen")
            }) {
                Text(text = "Support Multi-Screen")
            }
        }
        item {
            Button(onClick = {
                navHostController.navigate("haze_screen")
            }) {
                Text(text = "Haze Screen")
            }
        }
        item {
            Button(onClick = {
                navHostController.navigate("wallet_screen")
            }) {
                Text(text = "Wallet App")
            }
        }
        item {
            Button(onClick = {
                navHostController.navigate("rental_cars_screen")
            }) {
                Text(text = "Rental Cars App")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    ComposeFirstTheme {
        HomeScreen(navHostController = rememberNavController())
    }
}

@Preview(showBackground = true)
@Composable
fun LazyRowScreen() {
    LazyRow(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        itemsIndexed(item) { _, item ->
            Spacer(modifier = Modifier.width(8.dp))
            RowItem(item = item)
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}


@Composable
fun RowItem(item: Item) {
    Column(
        modifier = Modifier
            .height(350.dp)
            .width(200.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            painter = painterResource(id = item.image),
            contentDescription = item.title,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = item.title, fontWeight = FontWeight.SemiBold)
    }
}

@Preview(showBackground = true)
@Composable
fun LazyColumnScreen() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        itemsIndexed(item) { _, item ->
            ColumnItem(item = item)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun ColumnItem(item: Item) {
    Column(
        modifier = Modifier
            .height(350.dp)
            .width(200.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            painter = painterResource(id = item.image),
            contentDescription = item.title,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = item.title, fontWeight = FontWeight.SemiBold)
    }
}

@Preview(showBackground = true)
@Composable
fun LazyGridScreen() {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 16.dp),
        columns = GridCells.Fixed(3),
    ) {
        itemsIndexed(item) { _, item ->
            GridItem(item)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun GridItem(item: Item) {
    Column(
        modifier = Modifier
            .height(200.dp)
            .width(200.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(),
            painter = painterResource(id = item.image),
            contentDescription = item.title,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = item.title, fontWeight = FontWeight.SemiBold)
    }
}