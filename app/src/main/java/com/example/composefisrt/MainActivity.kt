package com.example.composefisrt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composefisrt.ui.AnimationScreen
import com.example.composefisrt.ui.CanvasExample
import com.example.composefisrt.ui.HomeScreen
import com.example.composefisrt.ui.LazyColumnScreen
import com.example.composefisrt.ui.LazyGridScreen
import com.example.composefisrt.ui.LazyRowScreen
import com.example.composefisrt.ui.Media3Explay
import com.example.composefisrt.ui.MyViewModelScreen
import com.example.composefisrt.ui.NavigateExample
import com.example.composefisrt.ui.ProfileScreen
import com.example.composefisrt.ui.RatingScreen
import com.example.composefisrt.ui.ScaffoldBottom
import com.example.composefisrt.ui.VoyagerNavigate
import com.example.composefisrt.ui.YoutubePlayerScreen
import com.example.composefisrt.ui.theme.ComposeFirstTheme
import com.example.composefisrt.ui.theme.font

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeFirstTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navHostController = rememberNavController()
                    NavHost(navHostController, startDestination = "home_screen") {
                        composable("home_screen") {
                            HomeScreen(navHostController)
                        }
                        composable("lazy_row_screen") {
                            LazyRowScreen()
                        }
                        composable("lazy_column_screen") {
                            LazyColumnScreen()
                        }
                        composable("lazy_grid_screen") {
                            LazyGridScreen()
                        }
                        composable("scaffold_bottom") {
                            ScaffoldBottom()
                        }
                        composable("window_size_screen") {
                            ProfileScreen()
                        }
                        composable("my_viewmodel") {
                            MyViewModelScreen()
                        }
                        composable("animation_screen") {
                            AnimationScreen()
                        }
                        composable("canvas_screen") {
                            CanvasExample()
                        }
                        composable("navigate_screen") {
                            NavigateExample()
                        }
                        composable("media3_screen") {
                            Media3Explay()
                        }
                        composable("voyager_screen") {
                            VoyagerNavigate()
                        }
                        composable("rating_screen") {
                            RatingScreen()
                        }
                        composable("youtube_screen") {
                            YoutubePlayerScreen()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun FirstUi() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(Modifier.height(200.dp))
        val shadowOffset = Offset(5f, 10f)
        Text(
            text = buildAnnotatedString {
                append("Some text ")
                withStyle(
                    SpanStyle(
                        color = Color.Red,
                        textDecoration = TextDecoration.LineThrough,
                        fontSize = 30.sp
                    )
                ) {
                    append(" is written ")
                }

                append("YES")
            },
            color = MaterialTheme.colorScheme.primary,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontFamily = font,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 25.sp,
            textDecoration = TextDecoration.Underline,
            style = TextStyle(
                shadow = Shadow(
                    Color.Gray, shadowOffset, 9f
                )
            )
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ComposeFirstTheme {
        FirstUi()
    }
}