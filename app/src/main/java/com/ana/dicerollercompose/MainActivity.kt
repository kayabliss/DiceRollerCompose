package com.ana.dicerollercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ana.dicerollercompose.ui.theme.DiceRollerComposeTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerComposeTheme {
                // Call the function from the body
                DiceRollerApp()
            }
        }
    }
}

@Preview
@Composable
fun DiceRollerApp(){//fillMaxSize functions take advantage of full screen
    DiceWithButtonAndImage(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))
}
@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier){ // expects a modifier instance as a parameter
   var result by remember { mutableStateOf(1) }
    // in order to have a composable function remember a value it has to call "by remember"
    // mutablestate of" is an observable, it will observe the variable of any changes
//to inform compose to watch the variable " result" for changes
    val imageResource = when(result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    // Creating a vertical layout using column(), places children vertically
    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(imageResource),
            contentDescription = result.toString()//
        )
        // Gives you space btw the image and the button spacer()
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { result = (1..6).random() }) {
            Text(text = stringResource(R.string.roll), fontSize = 24.sp)
        }

    }
}
