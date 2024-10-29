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
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.alliwonka.dexapp.ui.theme.MarianBlue
import com.alliwonka.dexapp.ui.theme.Platinum
import com.alliwonka.dexapp.ui.theme.RoseRed
import com.alliwonka.dexapp.ui.theme.Timberwolf

private var playerPosition by mutableStateOf(Pair(0, 0))

class HomeActivity : ComponentActivity() {
    
    private val items = HomeInventory.homeInventory.getItems()
    private var showMap by mutableStateOf(false)

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

        if (!showMap) {
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
        } else {
            Column(
                modifier = Modifier
                    .background(color = RoseRed)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MapHeader()
                Map()
                LowerThird()
            }
        }
    }

    @Composable
    fun LowerThird() {
        Row(Modifier.fillMaxSize().padding(15.dp).padding(start = 5.dp),
            Arrangement.spacedBy(15.dp)) {
            Button(onClick = { showMap = false },
                colors = ButtonDefaults.buttonColors(containerColor = MarianBlue),
                modifier = Modifier.padding(5.dp)) {
                Text(
                    text = "Back",
                    color = Timberwolf,
                    fontSize = 26.sp,
                    fontFamily = GoogleSansBold
                )
            }
            Button(onClick = { TODO() },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
                modifier = Modifier.padding(5.dp)) {
                Text(
                    text = "Target Location",
                    color = Timberwolf,
                    fontSize = 23.sp,
                    fontFamily = GoogleSansBold
                )
            }
        }
    }

    @Composable
    fun Map() {
        val scalingFactor = 0.5
        val mapWidth = 1800     /* original width of bright_archipelago.svg */
        val mapHeight = 1800    /* original height of bright_archipelago.svg */
        val scaledMapWidth = mapWidth * scalingFactor
        val scaledMapHeight = mapHeight * scalingFactor

        val mapPosition = Pair(playerPosition.first.coerceIn(0, mapWidth), playerPosition.second.coerceIn(0, mapHeight))

        val playerPositionX = (mapPosition.first * scalingFactor).dp
        val playerPositionY = (mapPosition.second * scalingFactor).dp

        val constrainedX = playerPositionX.coerceIn(0.dp, scaledMapWidth.dp)
        val constrainedY = playerPositionY.coerceIn(0.dp, scaledMapHeight.dp)

        Box(
            modifier = Modifier
                .padding(10.dp)
                .wrapContentSize()
                .aspectRatio(1f)
        ) {
            Image(
                painter = painterResource(R.drawable.bright_archipelago),
                contentDescription = R.string.Map.toString(),
                modifier = Modifier.fillMaxSize().clickable {
                    sendMessage("PlayerPosition")
                    println("playerPosition: $playerPosition")
                    println("mapPosition: $mapPosition")
                }
            )

            Icon(
                painter = painterResource(R.drawable.user),
                contentDescription = "Player Position",
                modifier = Modifier
                    .size(24.dp)
                    .offset(
                        x = constrainedX,
                        y = constrainedY
                    )
            )
        }
    }

    @Preview
    @Composable
    fun MapHeader() {
        Image(painter = painterResource(R.drawable.frame),
            contentDescription = "Just a picture")
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            modifier = Modifier
                .padding(horizontal = 14.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Image(
                painterResource(R.drawable.just_a_line),
                contentDescription = null,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Text(
                text = stringResource(id = R.string.Map),
                style = HomeRoomTextStyle
            )
            Image(
                painterResource(R.drawable.just_a_line),
                contentDescription = null,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
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
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(22.dp)
                .clickable {
                    showMap = true
                    sendMessage("PlayerPosition")
                }
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

fun updatePosition(newX: Int, newY: Int) {
    playerPosition = Pair(newX, newY)
    println(playerPosition)
}