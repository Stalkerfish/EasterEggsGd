package dex

import androidx.compose.animation.core.*
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import androidx.compose.ui.window.Dialog
import kotlinx.coroutines.delay
import java.io.File


@Composable
fun Earth(onNavigate: (Room) -> Unit) {
    val earthBackground = Brush.verticalGradient(
        colors = listOf(Color(0xFF1B5E20), Color(0xFF4CAF50), Color(0xFF81C784))    // put a name in this colors
    )
    val inventory = EarthInventory.earthInventory

    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = earthBackground)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                EarthRotationAnimation()
                Spacer(modifier = Modifier.height(60.dp))
                PeriodicTable()
                Row(modifier = Modifier.wrapContentWidth()) {
                    TodaysElement(onNavigate = onNavigate)
                    Spacer(Modifier.width(10.dp))
                    AlchemySection()
                }
                Inventory(inventory.getItems())

            }
            AnimatedNavigationBar(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth(),
                onNavigate = onNavigate
            )
        }
    }
}

@Composable
fun EarthRotationAnimation() {
    // Load the entire spritesheet (1920x532 size, 2 rows of 8 icons)
    val imageBitmap = remember {
        loadImageBitmap(
            File("src/main/resources/drawable/earth.png")
                .inputStream())
    }

    // Number of frames in the spritesheet
    val totalFrames = 16 // 2 rows x 8 columns

    // Size of each individual frame
    val frameWidth = 176  // Width of each icon
    val frameHeight = 230 // Height of each icon

    // Spacing
    val leftMargin = 58 // Adjust based on measurement from the left edge to the first icon
    val horizontalSpacing = 56 // Adjust based on measurement between icons
    val verticalSpacing = 20 // Adjust based on measurement between rows

    // Remember the index for the current frame
    var currentFrame by remember { mutableStateOf(0) }

    // Animating the frame change
    LaunchedEffect(Unit) {
        while (true) {
            delay(100L) // Adjust speed (100ms per frame)
            currentFrame = (currentFrame + 1) % totalFrames
        }
    }

    // Draw the current frame
    Canvas(modifier = Modifier.size(frameWidth.dp, frameHeight.dp)) {
        drawIntoCanvas { canvas ->
            // Calculate the row (0 or 1) and column (0-7) for the current frame
            val row = currentFrame / 8
            val column = currentFrame % 8

            // Calculate the offset for the current frame in the spritesheet, incorporating spacing
            val srcOffset = IntOffset(
                x = leftMargin + column * (frameWidth + horizontalSpacing),
                y = row * (frameHeight + verticalSpacing)
            )

            // Define the source size (frame size)
            val srcSize = IntSize(frameWidth, frameHeight)

            // Draw the cropped frame from the spritesheet
            canvas.drawImageRect(
                image = imageBitmap,
                srcOffset = srcOffset,   // Offset within the spritesheet
                srcSize = srcSize,       // Size of the individual frame
                dstOffset = IntOffset.Zero, // Where to start drawing in the canvas
                dstSize = IntSize(frameWidth, frameHeight), // Ensure the destination size matches the frame size
                paint = Paint() // Default paint object
            )
        }
    }
}

@Composable
fun PeriodicTable() {
    // Load the vector drawable from resources
    val molecule: Painter = painterResource(resourcePath = "drawable/molecule.svg")

    Box(
        contentAlignment = Alignment.CenterStart, modifier = Modifier.padding(22.dp) .size(349.dp, 115.dp)
            .background(Nyanza, RoundedCornerShape(10.dp, 10.dp, 10.dp, 45.dp))
            .clickable { TODO() }) {

        Image(
            painter = molecule,
            contentDescription = the_periodic_table_of_elements,
            modifier = Modifier
                .padding(start = 15.dp, end = 26.dp) // Adjust this based on your layout needs
        )

        // Add the Button on top of the background image
        Text(
            modifier = Modifier.align(Alignment.CenterEnd) .padding(end = 24.dp),
            text = the_periodic_table_of_elements,
            fontFamily = GoogleSansBold,
            fontSize = 21.sp,
            color = DrabDarkBrown,
            textAlign = TextAlign.End
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Inventory(itemList: MutableList<Item>) {
    // Load the vector drawable from resources
    val molecule: Painter = painterResource(resourcePath = "drawable/backpack.svg")
    var showDialog by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf<String?>(null) }

    Box(
        contentAlignment = Alignment.Center, modifier = Modifier.padding(22.dp) .size(349.dp, 115.dp)
            .background(Nyanza, RoundedCornerShape(10.dp, 10.dp, 45.dp, 10.dp))
            .clickable { showDialog = true }) {

        Image(
            painter = molecule,
            contentDescription = inventory,
            modifier = Modifier
                .padding(start = 55.dp, end = 22.dp) .align(Alignment.CenterEnd) // Adjust this based on your layout needs
        )

        // Add the Button on top of the background image
        Text(
            modifier = Modifier.align(Alignment.CenterStart) .padding(start = 24.dp),
            text = inventory,
            fontFamily = GoogleSansBold,
            fontSize = 32.sp,
            color = DrabDarkBrown,
            textAlign = TextAlign.Center
        )
    }
    // Show dialog
    if (showDialog) {
        Dialog(onDismissRequest = { showDialog = false }) {
            Surface(
                modifier = Modifier.size(500.dp),
                shape = RoundedCornerShape(30.dp),
                color = Nyanza
            ) {
                if (itemList.isNotEmpty()) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(
                            text = "Select an Item",
                            fontSize = 20.sp,
                            fontFamily = GoogleSansBold,
                            color = DrabDarkBrown,
                            modifier = Modifier.padding(8.dp)
                        )
                        itemList.forEach { item ->
                            ListItem(
                                text = { item.name?.let { Text(text = it) } },
                                modifier = Modifier.clickable {
                                    selectedItem = item.toString()
                                    item.useItem()
                                    itemList.remove(item)
                                    showDialog = false // Close the dialog
                                }
                            )
                        }
                    }
                } else {
                    Column(modifier = Modifier.fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center) {
                        Text(
                            text = empty_sign,
                            fontSize = 20.sp,
                            fontFamily = GoogleSansBold,
                            color = DrabDarkBrown,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TodaysElement(onNavigate: (Room) -> Unit) {
    Box(modifier = Modifier
        .width(180.dp)
        .wrapContentHeight()
        .padding(start = 22.dp)
        .background(Nyanza, RoundedCornerShape(15.dp))
        .clickable { onNavigate(Room.ElementsQuiz) }) {

        Column(modifier = Modifier.padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painterResource("drawable/hydrogen.svg"), hydrogen)
            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = what_is_the_element,
                fontFamily = GoogleSansBold,
                fontSize = 16.sp,
                color = DrabDarkBrown,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun AlchemySection() {
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
        .width(180.dp)
        .wrapContentHeight()
        .padding(start = 30.dp, end = 22.dp)
        .background(Nyanza, RoundedCornerShape(15.dp))
        .clickable { TODO() }) {

        Column(modifier = Modifier.padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painterResource("drawable/bohr.svg"), play_with_the_elements,
                modifier = Modifier.size(98.dp, 98.dp))
            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = play_with_the_elements,
                fontFamily = GoogleSansBold,
                fontSize = 16.sp,
                color = DrabDarkBrown,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun AnimatedNavigationBar(modifier: Modifier = Modifier, onNavigate: (Room) -> Unit) {
    var selectedItem by remember { mutableStateOf("Earth") }

    Row(
        modifier = modifier
            .height(70.dp)
            .background(Color(0xFF1B5E20).copy(alpha = 0.9f))
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AnimatedNavigationIcon("Home", selectedItem == "Home", { selectedItem = "Home"; onNavigate(Room.Home) })
        AnimatedNavigationIcon("Earth", selectedItem == "Earth", { selectedItem = "Earth"; onNavigate(Room.EARTH) })
        AnimatedNavigationIcon("Settings", selectedItem == "Settings", { selectedItem = "Settings"; onNavigate(Room.Settings) })
    }
}

@Composable
fun AnimatedNavigationIcon(name: String, isSelected: Boolean, onClick: () -> Unit) {
    val scale by animateFloatAsState(
        targetValue = if (isSelected) 1.2f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .scale(scale)
                .clip(CircleShape)
                .background(if (isSelected) Color.White else Color.White.copy(alpha = 0.7f))
        ) {
            Text(
                text = name.first().toString(),
                color = Color(0xFF1B5E20),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = name,
            color = if (isSelected) Color.White else Color.White.copy(alpha = 0.7f),
            fontSize = 12.sp
        )
    }
}

@Preview
@Composable
fun PreviewEarth() {
    Earth(onNavigate = {})
}