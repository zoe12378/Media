package com.edu.pu.s1115076.media

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.edu.pu.s1115076.media.ui.theme.MediaTheme

class VideoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MediaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2("第二頁")
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    val link = "https://redirector.googlevideo.com/videoplayback?expire=1716995908&ei=5PJWZvbvHam16dsPy4GbkAs&ip=2a01%3A4f8%3A242%3A16d9%3A%3A2&id=o-ABM3uZdTTs1vvK7CGyD-XtIIIRXUi-Lo5VzZchpJnlRt&itag=22&source=youtube&requiressl=yes&xpc=EgVo2aDSNQ%3D%3D&mh=JL&mm=31%2C29&mn=sn-4g5ednds%2Csn-4g5e6nzl&ms=au%2Crdu&mv=m&mvi=4&pl=44&initcwndbps=560000&siu=1&vprv=1&svpuc=1&mime=video%2Fmp4&rqh=1&cnr=14&ratebypass=yes&dur=230.179&lmt=1710714993096774&mt=1716973978&fvip=1&c=ANDROID_TESTSUITE&txp=4532434&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cxpc%2Csiu%2Cvprv%2Csvpuc%2Cmime%2Crqh%2Ccnr%2Cratebypass%2Cdur%2Clmt&sig=AJfQdSswRQIgb2jaSSeQjgHUW4rhWck1ycyAMEUpd9BOGSqtdQY3jysCIQDleECJHBObdTVNpGjTKHewAgFR08bgthRz1HQQtSenkw%3D%3D&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AHWaYeowRAIgfpZfCoxSzeOYgUAfJukGunvPMjlLnflEc7RKdPnX1NwCICQTCdhE6t62V1HmAjf7STW1p8kmTIgFGj5gQkzJ4Zqy&range=0-14924001&title=X2Download.com-ChihSiou%20%E6%8C%81%E4%BF%AE%20[%20%E6%88%91%E9%82%84%E5%9C%A8%E4%BD%A0%E7%9A%84%E5%A4%A2%E8%A3%A1%E5%97%8E%20]%20Official%20Music%20Video"
    val exoPlayer = ExoPlayer.Builder(context).build()

    val mediaItem = MediaItem.fromUri(android.net.Uri.parse(link))
    exoPlayer.setMediaItem(mediaItem)

    val playerView = PlayerView(context)
    playerView.player = exoPlayer
    DisposableEffect(AndroidView(factory = {playerView})){
        exoPlayer.prepare()
        exoPlayer.playWhenReady = true

        onDispose{
            exoPlayer.release()
        }
    }

    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    MediaTheme {
        Greeting2("Android")
    }
}