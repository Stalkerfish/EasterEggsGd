package dex

import TableOfElements
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import awesome_dialog.AwesomeCustomDialog
import awesome_dialog.AwesomeCustomDialogType
import dex.*
import kotlin.random.Random

@Composable
fun WhatIsTheElement (onNavigate: (Room) -> Unit) {
    val elementList = TableOfElements.getElement()
    val randomElement = elementList[Random.nextInt(0, elementList.size)]

    var timesClicked by remember { mutableStateOf(0) }

    var textState by remember { mutableStateOf(TextFieldValue("")) }

    val feedbackMessage = remember { mutableStateOf("") }

    val successDialog = remember { mutableStateOf(false) }
    val errorDialog = remember { mutableStateOf(false) }
    var infoDialog = remember { mutableStateOf(false) }

    val inventory = EarthInventory.earthInventory

    MaterialTheme() {
        Column(modifier = Modifier
            .background(color = Nyanza)
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 25.dp, bottom = 20.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painterResource("drawable/backIcon.png"), null,
                Modifier.align(Alignment.Start) .size(60.dp, 60.dp) .padding(start = 10.dp)
                    .clickable { onNavigate(Room.EARTH) })
            Text(
                modifier = Modifier.padding(top = 35.dp),
                text = what_is_the_element,
                fontFamily = GoogleSansBold,
                fontSize = 28.sp,
                color = DrabDarkBrown,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(100.dp))

            Element(randomElement, timesClicked)

            Spacer(Modifier.height(45.dp))

            OutlinedTextField(
                value = textState,
                onValueChange = { textState = it },
                label = { Text("What is the element?") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedLabelColor = Jade, // Color for the hint when focused (dex.getJade color)
                    unfocusedLabelColor = Color.White,  // Color for the hint when not focused
                    unfocusedBorderColor = Color.White,
                    focusedBorderColor = Jade
                ),
                modifier = Modifier.width(350.dp),
                textStyle = TextStyle(
                    fontSize = 18.sp,
                    color = Color.White
                )
            )
            Spacer(Modifier.height(30.dp))

            Text(
                modifier = Modifier.padding(20.dp),
                text = randomElement.description,
                fontFamily = GoogleSansBold,
                fontSize = 20.sp,
                color = DrabDarkBrown,
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(40.dp))
            Row(horizontalArrangement = Arrangement.Start) {
                HintButton(onClick = { timesClicked++ })
                Spacer(Modifier.width(50.dp))
                AcceptButton(onClick = {
                    if (textState.text.isEmpty()) {
                        feedbackMessage.value = "Please enter an answer."
                        infoDialog.value = true

                    } else if (textState.text contentEquals (randomElement.name)) {
                        feedbackMessage.value = "Correct! 🎉"
                        successDialog.value = true

                        if (timesClicked >= 3) {
                            val orb = Orb(Room.Hell, Room.Hell.name, onNavigate)
                            inventory.addItem(orb)
                        }
                        if (timesClicked == 2) {
                            val orb = Orb(Room.Hell, Room.Hell.name, onNavigate)
                            inventory.addItem(orb)
                            inventory.addItem(orb)
                        }
                        if (timesClicked == 1) {
                            val orb = Orb(Room.Hell, Room.Hell.name, onNavigate)
                            inventory.addItem(orb)
                            inventory.addItem(orb)
                            inventory.addItem(orb)
                        }
                        if (timesClicked == 0) {
                            val orb = Orb(Room.Hell, Room.Hell.name, onNavigate)
                            inventory.addItem(orb)
                            inventory.addItem(orb)
                            inventory.addItem(orb)
                            inventory.addItem(orb)
                        }
                    } else {
                        feedbackMessage.value = "Incorrect! Try again."
                        errorDialog.value = true
                    }
                })
            }
            if (infoDialog.value){
                AwesomeCustomDialog(
                    type = AwesomeCustomDialogType.INFO,
                    title = "Info",
                    desc = feedbackMessage.value,
                    onDismiss = { infoDialog.value = false }
                )
            } else if (successDialog.value){
                AwesomeCustomDialog(
                    type = AwesomeCustomDialogType.SUCCESS,
                    title = "Correct Answer",
                    desc = feedbackMessage.value,
                    onDismiss = {
                        successDialog.value = false
                        onNavigate(Room.EARTH)
                    }
                )
            } else if (errorDialog.value){
                AwesomeCustomDialog(
                    type = AwesomeCustomDialogType.ERROR,
                    title = "Wrong Answer",
                    desc = feedbackMessage.value,
                    onDismiss = { errorDialog.value = false }
                )
            }
        }
    }
}

@Composable
fun HintButton(onClick: () -> Unit) {

    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
        .size(150.dp, 55.dp)
        .padding(start = 20.dp, bottom = 7.dp)
        .clickable { onClick() }
        .background(Roti, RoundedCornerShape(20.dp))
    ) {
        Text(
            text = "Hint",
            fontSize = 20.sp,
            color = Color(0xFF636940),
            fontFamily = GoogleSansBold,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun AcceptButton(onClick: () -> Unit) {
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(150.dp, 55.dp)
            .padding(start = 20.dp, bottom = 7.dp)
            .clickable { onClick() }
            .background(Color(0xFF4CAF50), RoundedCornerShape(20.dp))
    ) {
        Text(
            text = "Accept",
            fontSize = 20.sp,
            color = Color.White,
            fontFamily = GoogleSansBold,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
@Preview
fun preview(){
    WhatIsTheElement(onNavigate = {})
}

@Composable
fun Element(element: Element, hintNumber: Int) {
    Box(
        modifier = Modifier
            .size(200.dp, 200.dp)
            .background(Cordovan, RoundedCornerShape(8.dp))
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            if (hintNumber >= 1) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = element.atomicNumber.toString(),
                    fontFamily = GoogleSansBold,
                    fontSize = 32.sp,
                    color = Color.White,
                    textAlign = TextAlign.Start
                )
                Spacer(Modifier.width(80.dp))
            }
            if (hintNumber >= 2) {
                Text(
                    modifier = Modifier.padding(top = 10.dp, end = 8.dp),
                    text = element.atomicWeight.toString(),
                    fontFamily = GoogleSansBold,
                    fontSize = 18.sp,
                    color = Color.White,
                    textAlign = TextAlign.Start
                )
            }
        }
        if (hintNumber >= 3) {
            Text(modifier = Modifier.align(Alignment.Center),
                text = element.symbol,
                fontFamily = GoogleSansBold,
                fontSize = 64.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
        val elementName =
            Text(
            modifier = Modifier.padding(bottom = 15.dp) .align(Alignment.BottomCenter),
            text = hidden_name,
            fontFamily = GoogleSansBold,
            fontSize = 18.sp,
            color = Color.White,
            textAlign = TextAlign.Center
        )
    }
}