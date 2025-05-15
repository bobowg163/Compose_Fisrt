package com.example.composefisrt.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ImageNotSupported
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.composefisrt.R
import com.example.composefisrt.ui.theme.ComposeFirstTheme

@Composable
fun ImageCompose() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 45.dp, bottom = 16.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val imageUrl =
            "https://img.alicdn.com/imgextra/i3/2211549132990/O1CN01eMUOXt1XxTD0szB6S_!!0-item_pic.jpg"
        val model = ImageRequest.Builder(LocalContext.current).data(imageUrl).size(Size.ORIGINAL)
            .build()
        val imageState = rememberAsyncImagePainter(model = model).state
        Image(
            modifier = Modifier.clip(RoundedCornerShape(20.dp)),
            painter = painterResource(R.drawable.mhm),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(12.dp))
        Box(
            modifier = Modifier
                .size(300.dp)
                .background(MaterialTheme.colorScheme.secondaryContainer)
        ) {
            when (imageState) {
                AsyncImagePainter.State.Empty -> {
                    Icon(
                        modifier = Modifier
                            .size(100.dp)
                            .align(alignment = Alignment.Center),
                        imageVector = Icons.Rounded.ImageNotSupported,
                        contentDescription = null
                    )
                }

                is AsyncImagePainter.State.Error -> {
                    Icon(
                        modifier = Modifier
                            .size(100.dp)
                            .align(alignment = Alignment.Center),
                        imageVector = Icons.Rounded.ImageNotSupported,
                        contentDescription = null
                    )
                }

                is AsyncImagePainter.State.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .size(100.dp)
                            .align(Alignment.Center),
                        color = MaterialTheme.colorScheme.primary
                    )
                }

                is AsyncImagePainter.State.Success -> {
                    Image(
                        modifier = Modifier.clip(RoundedCornerShape(20.dp)),
                        painter = imageState.painter,
                        contentDescription = null
                    )
                }
            }

        }

    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun ImageComposePreview() {
    ComposeFirstTheme {
        ImageCompose()
    }
}