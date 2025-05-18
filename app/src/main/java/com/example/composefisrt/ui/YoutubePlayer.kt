package com.example.composefisrt.ui

import android.net.Uri
import android.widget.MediaController
import android.widget.VideoView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.net.toUri
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

/**
 * 项目名称：Compose Fisrt
 * 包名：com.example.composefisrt.ui
 * 日期：2025/5/18时间：20:43
 * 作者: bobowg
 * 备注： 播放youtube视频和本地视频
 * 加载媒体库 yt-dlp = { group = "com.pierfrancescosoffritti.androidyoutubeplayer", name = "chromecast-sender", version.ref = "chromecast" }
 **/

@Preview
@Composable
fun YoutubePlayerScreen() {
    val videoUri = "android.resource://com.example.composefisrt/raw/mhmcg".toUri()
    Column {
        YoutubePlayer(
            youtubeVideoId = "UCzYdNxSgeZ0m85jamNjovEA",
            lifecycleOwner = LocalLifecycleOwner.current
        )
        Spacer(modifier = Modifier.height(11.dp))
        VideoPlayer(
            videoUri = videoUri
        )
    }
}

@Composable
fun YoutubePlayer(
    youtubeVideoId: String,
    lifecycleOwner: LifecycleOwner
) {
    AndroidView(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp)),
        factory = { context ->
            YouTubePlayerView(context = context).apply {
                lifecycleOwner.lifecycle.addObserver(this)
                addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                    override fun onReady(youTubePlayer: YouTubePlayer) {
                        youTubePlayer.loadVideo(youtubeVideoId, 0f)
                    }
                })
            }
        }
    )
}

@Composable
fun VideoPlayer(
    videoUri: Uri
) {
    AndroidView(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp)),
        factory = { context ->
            VideoView(context).apply {
                setVideoURI(videoUri)
                val mediaController = MediaController(context)
                mediaController.setAnchorView(this)
                setMediaController(mediaController)
                setOnPreparedListener {
                    it.isLooping = true
                    start()
                }
            }
        })
}