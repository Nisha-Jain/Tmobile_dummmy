package com.example.tmobile.activity

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tmobile.ui.theme.TMobileTheme

@Composable
fun ListScreen(name: String, modifier: Modifier = Modifier, buttonClick :()  -> Unit = {}) {
    Column {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Button(
            onClick = {
                buttonClick()
                Log.d("Hellfdshbfhss","My nam e")
            },
            modifier = Modifier.padding(5.dp),
            enabled = true,
            shape = ButtonDefaults.shape,
            colors = ButtonColors(
                Color.Red,
                contentColor = Color.Black,
                disabledContainerColor = Color.DarkGray,
                disabledContentColor = Color.Cyan,
            ),
        ) {
            Text(
                text = "Hello $!",
                modifier = modifier
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListScreenPreview() {
    TMobileTheme {
        ListScreen("Android")
    }
}