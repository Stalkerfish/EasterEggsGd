package com.alliwonka.dexapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemColors
import androidx.compose.material3.Surface
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.alliwonka.dexapp.ui.theme.GoogleSansBold
import com.alliwonka.dexapp.ui.theme.MarianBlue
import com.alliwonka.dexapp.ui.theme.Timberwolf

@Composable
fun Wardrobe(itemList: MutableList<Item>) {
    Column {
        WardrobeShelf(itemList)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(id = R.string.wardrobe),
            fontSize = 18.sp,
            fontFamily = GoogleSansBold,
            color = Timberwolf,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}


@Composable
fun WardrobeShelf(itemList: MutableList<Item>) {
    var showDialog by remember { mutableStateOf(false) }
    val imagePainter: Painter = painterResource(R.drawable.wardrobe)

    // Show image and handle click
    Image(
        painter = imagePainter,
        contentDescription = null,
        modifier = Modifier.clickable { showDialog = true }
    )
    // Show dialog
    if (showDialog) {
        DialogContent(onDismiss = { showDialog = false }, itemList = itemList)
    }
}

@Composable
fun DialogContent(
    onDismiss: () -> Unit,
    itemList: MutableList<Item>,
) {
    var selectedItem by remember { mutableStateOf<String?>(null) }

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            modifier = Modifier.size(500.dp),
            shape = RoundedCornerShape(30.dp),
            color = MarianBlue
        ) {
            Column(
                modifier = Modifier.padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                when {
                    itemList.isNotEmpty() -> {
                        Text(
                            text = "Select an Orb",
                            fontSize = 20.sp,
                            fontFamily = GoogleSansBold,
                            color = Timberwolf,
                            modifier = Modifier.padding(8.dp)
                        )
                        itemList.forEach { item ->
                            ListItem(
                                colors = ListItemColors(
                                    containerColor = MarianBlue,
                                    disabledHeadlineColor = Color.Transparent,
                                    disabledTrailingIconColor = Color.Transparent,
                                    headlineColor = Timberwolf,
                                    trailingIconColor = Timberwolf,
                                    disabledLeadingIconColor = Color.Transparent,
                                    leadingIconColor = Timberwolf,
                                    overlineColor = Color.Transparent,
                                    supportingTextColor = Color.Transparent),
                                headlineContent = {
                                    Text(text = item.name ?: "") },
                                    modifier = Modifier
                                        .clickable {
                                            selectedItem = item.name
                                            item.useItem()
                                            itemList.remove(item)
                                            onDismiss() // Close the dialog after selection
                                        })
                        }
                    }
                    else -> {
                        NoOrbSign()
                    }
                }
            }
        }
    }
}

@Composable
fun NoOrbSign() {
    Text(
        text = stringResource(id = R.string.there_is_no_orbs_here),
        fontSize = 20.sp,
        fontFamily = GoogleSansBold,
        color = Timberwolf,
        modifier = Modifier.padding(8.dp)
    )
}

@Preview
@Composable
fun PreviewWardrobe() {
    Wardrobe(itemList = mutableListOf())
}