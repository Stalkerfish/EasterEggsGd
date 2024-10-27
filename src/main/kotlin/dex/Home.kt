package dex

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

var playerPosition: Pair<Int, Int> = Pair(0,0)

@Composable
fun Home(onNavigate: (Room) -> Unit) {
    var showMap by remember { mutableStateOf(false) }
    var mapPosition by remember { mutableStateOf(playerPosition) }

    MaterialTheme {
        Column(
            modifier = Modifier
                .background(color = RoseRed)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            val inventory = HomeInventory.homeInventory
            val items = inventory.getItems()

            Image(
                painterResource("drawable/frame.png"),
                contentDescription = null,
                modifier = Modifier.clickable { launchGodotGame() }
            )

            Spacer(modifier = Modifier.height(15.dp))

            if (!showMap) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(Modifier.padding(10.dp)) {
                        Title(home_room)
                        Image(
                            painterResource("drawable/just_a_line.svg"),
                            contentDescription = null,
                            modifier = Modifier.padding(14.dp)
                        )
                    }
                    Row(Modifier.padding(10.dp)) {
                        HomeWidgets(items)
                    }
                    MidButton(onClick = {
                        showMap = true
                        sendMessage("PlayerPosition")
                        println("playerPosition: $playerPosition")
                        println("mapPosition: $mapPosition")
                    })

                    Row(Modifier.padding(start = 35.dp)) {
                        BottomIcons(onNavigate)
                    }
                }
            } else {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 24.dp)
                            .fillMaxWidth()
                    ) {
                        Image(
                            painterResource("drawable/just_a_line.svg"),
                            contentDescription = null,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                        Title(Map)
                        Image(
                            painterResource("drawable/just_a_line.svg"),
                            contentDescription = null,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .padding(10.dp)
                            .wrapContentSize()
                            .aspectRatio(1f)
                    ) {
                        val scalingFactor = 0.2

                        Image(
                            painter = painterResource("drawable/bright_archipelago.svg"),
                            contentDescription = Map,
                            modifier = Modifier.fillMaxSize().clickable {
                                sendMessage("PlayerPosition")
                                mapPosition = playerPosition
                                println("playerPosition: $playerPosition")
                                println("mapPosition: $mapPosition")
                            }
                        )

                        Icon(
                            painter = painterResource("drawable/user.svg"),
                            contentDescription = "Player Position",
                            modifier = Modifier
                                .offset(
                                    x = (mapPosition.first * scalingFactor).dp,
                                    y = (mapPosition.second * scalingFactor).dp
                                )
                                .size(24.dp)
                        )
                    }

                    Row(Modifier.fillMaxSize().padding(15.dp).padding(start = 5.dp),
                        Arrangement.spacedBy(15.dp)) {
                        Button(onClick = { showMap = false },
                            colors = ButtonDefaults.buttonColors(backgroundColor = MarianBlue),
                            modifier = Modifier.padding(5.dp)) {
                            Text(
                                text = "Back",
                                color = Timberwolf,
                                fontSize = 26.sp,
                                fontFamily = GoogleSansBold
                            )
                        }
                        Button(onClick = { TODO() },
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF4CAF50)),
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
            }
        }
    }
}

fun updatePosition(newX: Int, newY: Int) {
    playerPosition = Pair(newX, newY)
    println(playerPosition)
}

@Preview
@Composable
fun PreviewHome() {
    // Provide a mock function for onNavigate
    Home(onNavigate = {
    })
}

@Composable
fun HomeWidgets(items: MutableList<Item>){
    Column {
        WardrobeShelf(
            path = "drawable/wardrobe.svg",
            itemList = items
        )

        Text(
            text = wardrobe,
            fontSize = 18.sp,
            fontFamily = GoogleSansBold,
            color = Timberwolf,
            modifier = Modifier.padding(48.dp, 8.dp, 0.dp, 0.dp)
        )
    }

    Column {
        Image(
            painterResource(resourcePath = "drawable/bag.svg"), null,
            modifier = Modifier
                .clickable { sendMessage("addOrb") }
                .padding(0.dp, 36.dp, 25.dp, 0.dp)
        )

        Text(
            text = bag,
            fontSize = 18.sp,
            fontFamily = GoogleSansBold,
            color = Timberwolf,
            modifier = Modifier.padding(42.dp, 0.dp, 0.dp, 0.dp)
        )
    }
}

@Composable
fun BottomIcons(onNavigate: (Room) -> Unit) {
    Image(painterResource(resourcePath = "drawable/book.svg"), null)
    Image(
        painterResource(resourcePath = "drawable/phone.svg"), null,
        modifier = Modifier
            .clickable { disconnectWebSocket() }
            .padding(50.dp, 0.dp, 10.dp, 0.dp)
    )
    Image(
        painterResource(resourcePath = "drawable/settings.svg"), null,
        modifier = Modifier
            .clickable { connectWebSocket(onNavigate) }
            .padding(35.dp, 0.dp, 10.dp, 0.dp)
    )
}

@Composable
@Preview
fun MidButton(onClick: () -> Unit) {
    // Load the vector drawable from resources
    val backgroundPainter: Painter = painterResource(resourcePath = "drawable/rectangle.svg")

    Box(
        contentAlignment = Alignment.Center, modifier = Modifier.padding(22.dp)
    ) {
        // Add the background image
        Image(
            painter = backgroundPainter,
            contentDescription = "Button Background",
            contentScale = ContentScale.FillBounds, // Fill the entire box
            modifier = Modifier
                .padding(8.dp) // Adjust this based on your layout needs
                .clickable { onClick() }
        )

        // Add the Button on top of the background image
        Text(
            text = "Open Map",
            fontFamily = GoogleSansBold,
            fontSize = 16.sp,
            color = Platinum
        )
    }
}

@Composable
fun Title(title: String) {
    Text(
        text = title,
        modifier = Modifier.padding(start = 10.dp, end = 10.dp),
        fontSize = 36.sp,
        fontFamily = GoogleSansBold,
        color = Timberwolf
    )
}

@OptIn(DelicateCoroutinesApi::class)
fun launchGodotGame() {
    GlobalScope.launch {
        GodotLauncher.launchGodotGame("scenes/main.tscn")
    }
}