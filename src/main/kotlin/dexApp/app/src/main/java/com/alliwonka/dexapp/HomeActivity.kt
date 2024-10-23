package com.alliwonka.dexapp

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import com.alliwonka.dexapp.ui.theme.DexAppTheme
import com.alliwonka.dexapp.ui.theme.GoogleSansBold
import com.alliwonka.dexapp.ui.theme.HomeRoomTextStyle
import com.alliwonka.dexapp.ui.theme.Platinum
import com.alliwonka.dexapp.ui.theme.RoseRed

class HomeActivity : ComponentActivity() {
    
    private val items = HomeInventory.homeInventory.getItems()

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                // Set the content to appear under the system bars so that the
                // content doesn't resize when the system bars hide and show.
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                // Hide the nav bar and status bar
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)


        enableEdgeToEdge()
        setContent {
            DexAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeContent(
                        modifier = Modifier.padding(innerPadding),
                        items = items,
                        onNavigate = {})
                }
            }
        }
    }

    @Composable
    fun HomeContent(
        items: MutableList<Item>,
        onNavigate: (Room) -> Unit,
        modifier: Modifier? = Modifier) {
        Column(
            modifier = Modifier
                .background(color = RoseRed)
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HomeHeader()

            Column(modifier = Modifier
                .wrapContentHeight()
                .align(Alignment.CenterHorizontally)) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally),
                    horizontalArrangement = Arrangement.SpaceEvenly) {
                    Wardrobe(items)
                    Spacer(Modifier.width(10.dp))
                    Bag()
                }
                MissionButton()
                BottomIcons(onNavigate)
            }
        }
    }

    @Composable
    fun BottomIcons(onNavigate: (Room) -> Unit) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Image(painterResource(R.drawable.book), null)
            Spacer(modifier = Modifier.width(5.dp))
            Image(painterResource(R.drawable.phone), null,
                Modifier.clickable { disconnectWebSocket() })
            Spacer(modifier = Modifier.width(5.dp))
            Image(painterResource(R.drawable.settings), null,
                Modifier.clickable { connectWebSocket(onNavigate) })
        }
    }

    @Preview
    @Composable
    fun MissionButton() {
        val backgroundPainter: Painter = painterResource(R.drawable.rectangle)

        Box(
            contentAlignment = Alignment.Center, modifier = Modifier.padding(22.dp)
        ) {
            // Add the background image
            Image(
                painter = backgroundPainter,
                contentDescription = "Button Background",
                contentScale = ContentScale.FillBounds, // Fill the entire box
                modifier = Modifier.padding(8.dp)
            )

            // Add the Button on top of the background image
            Text(
                text = "Go on a Mission",
                fontFamily = GoogleSansBold,
                fontSize = 16.sp,
                color = Platinum
            )
        }
    }

    @Preview
    @Composable
    fun PreviewHomeHeader() {
        HomeContent(items = items, onNavigate = {})
    }

    @Preview(showBackground = true)
    @Composable
    fun HomeHeader() {

        Image(painter = painterResource(R.drawable.frame), contentDescription = "Just a picture")
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            modifier = Modifier
                .padding(10.dp)
        ) {
            Text(
                text = stringResource(id = R.string.home_room),
                style = HomeRoomTextStyle
            )
            Image(
                painter = painterResource(R.drawable.just_a_line), null,
                modifier = Modifier
                    .padding(14.dp)
                    .align(Alignment.CenterVertically)
            )
        }
    }
}