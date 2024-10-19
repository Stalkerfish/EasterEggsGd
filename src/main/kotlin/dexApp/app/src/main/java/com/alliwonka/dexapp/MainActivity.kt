package com.alliwonka.dexapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alliwonka.dexapp.ui.theme.DexAppTheme
import com.alliwonka.dexapp.ui.theme.HomeRoomTextStyle
import com.alliwonka.dexapp.ui.theme.RoseRed

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DexAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun HomeContent(items: MutableList<Item>, onNavigate: (Room) -> Unit) {
    Column(
        modifier = Modifier
            .background(color = RoseRed)
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HomeHeader()
        //WardrobeAndBagSection(items)
        //LaunchButton(items, onNavigate)
        //BottomIcons()
    }
}

@Preview
@Composable
fun HomeHeader() {
    Text(
        text = stringResource(id = R.string.home_room),
        style = HomeRoomTextStyle
    )

    Image(painter = painterResource(R.drawable.frame), contentDescription = "Just a picture")
    Spacer(modifier = Modifier.height(15.dp))
    Row(modifier = Modifier.padding(10.dp), horizontalArrangement = Arrangement.Start) {
        Image(
            painter = painterResource(R.drawable.just_a_line), null,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(14.dp)
        )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DexAppTheme {
        Greeting("Android")
    }
}