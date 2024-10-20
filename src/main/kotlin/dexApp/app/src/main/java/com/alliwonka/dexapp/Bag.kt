package com.alliwonka.dexapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.alliwonka.dexapp.ui.theme.GoogleSansBold
import com.alliwonka.dexapp.ui.theme.Timberwolf

@Composable
fun Bag() {
    Column {
        Image(painterResource(R.drawable.bag), null)
        Text(
            text = stringResource(id = R.string.bag),
            fontSize = 18.sp,
            fontFamily = GoogleSansBold,
            color = Timberwolf,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Preview
@Composable
fun PreviewBag() {
    Bag()
}
