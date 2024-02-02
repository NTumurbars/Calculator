package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme{
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Calculator()
                }
            }
        }
    }
}

@Composable
fun Calculator(modifier: Modifier = Modifier) {

    var displayedText : String by remember { mutableStateOf("") }
    var action : String by remember { mutableStateOf("") }
    var argument1 : Int by remember { mutableStateOf(0) }
    var argument2 : Int by remember { mutableStateOf(0) }

    var state by remember { mutableStateOf(0) }

    fun turnNumIntoText(number : Int) : String
    {
        if (number == 0)
        {
            return ""
        }
        else
        {
            return number.toString()
        }
    }


    fun stateChecker(pressedNum: Int)
    {
        if(state == 0)
        {
            argument1 += pressedNum
        }
        if(state == 1)
        {
            argument2 += pressedNum
        }

    }



    var displayArg1 = turnNumIntoText(argument1)
    var displayArg2 = turnNumIntoText(argument2)
    displayedText = "$displayArg1 $action $displayArg2"


    Column(modifier = Modifier
        .statusBarsPadding()
        .padding(horizontal = 40.dp)
        .verticalScroll(rememberScrollState())
        .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Spacer(modifier = Modifier.height(50.dp))

        Text(
            modifier = Modifier.background(Color(0xC4B2E7FF))
                .size(width = 250.dp, height = 25.dp)
                .fillMaxWidth(),
            text = displayedText,
        )

        Spacer(modifier = Modifier.height(50.dp))

        Row(
            modifier = modifier
                .fillMaxWidth()
                .size(48.dp),
            verticalAlignment = Alignment.CenterVertically
        )
        {

            Button(onClick = {
                stateChecker(1)
            },
                shape = RoundedCornerShape(30.dp),
            )
            {
                Text(text = "1")
            }

            Button(onClick = {
                stateChecker(2)
            },
                shape = RoundedCornerShape(30.dp),
            )
            {
                Text(text = "2")
            }

            Button(onClick = {
                stateChecker(3)
            },
                shape = RoundedCornerShape(30.dp),
            )
            {
                Text(text = "3")
            }

            Spacer(modifier = Modifier.padding(15.dp))

            Button(onClick = {
                state++
                action = "+"
            },
                shape = RoundedCornerShape(30.dp),
            )
            {
                Text(text = "+")
            }

        }

        Row(
            modifier = modifier
                .fillMaxWidth()
                .size(48.dp),
            verticalAlignment = Alignment.CenterVertically
        )
        {

            Button(onClick = {
                stateChecker(4)
            },
                shape = RoundedCornerShape(30.dp),
            )
            {
                Text(text = "4")
            }

            Button(onClick = {
                stateChecker(5)
            },
                shape = RoundedCornerShape(30.dp),
            )
            {
                Text(text = "5")
            }

            Button(onClick = {
                stateChecker(6)
            },
                shape = RoundedCornerShape(30.dp),
            )
            {
                Text(text = "6")
            }

            Spacer(modifier = Modifier.padding(15.dp))

            Button(onClick = {
                state++
                action = "-"
            },
                shape = RoundedCornerShape(30.dp),
            )
            {
                Text(text = "-")
            }

        }

        Row(
            modifier = modifier
                .fillMaxWidth()
                .size(48.dp),
            verticalAlignment = Alignment.CenterVertically
        )
        {

            Button(onClick = {
                stateChecker(7)
            },
                shape = RoundedCornerShape(30.dp),
            )
            {
                Text(text = "7")
            }

            Button(onClick = {
                stateChecker(8)
            },
                shape = RoundedCornerShape(30.dp),
            )
            {
                Text(text = "8")
            }

            Button(onClick = {
                stateChecker(9)
            },
                shape = RoundedCornerShape(30.dp),
            )
            {
                Text(text = "9")
            }

            Spacer(modifier = Modifier.padding(15.dp))

            Button(onClick = {
                if(action == "+")
                {
                    argument1 = argument1 + argument2
                    argument2 = 0
                    action = ""
                    state = 0
                }

                if(action == "-")
                {
                    argument1 = argument1 - argument2
                    argument2 = 0
                    action = ""
                    state = 0
                }
            },
                shape = RoundedCornerShape(30.dp),
            )
            {
                Text(text = "=")
            }

        }

        Row(
            modifier = modifier
                .fillMaxWidth()
                .size(48.dp),
            verticalAlignment = Alignment.CenterVertically
        )
        {

            Spacer(modifier = Modifier.padding(30.dp))

            Button(onClick = {
                stateChecker(0)
            },
                shape = RoundedCornerShape(30.dp),
            )
            {
                Text(text = "0")
            }

            Spacer(modifier = Modifier.padding(35.dp))

            Button(onClick = {
                argument1 = 0
                argument2 = 0
                action = ""
                state = 0
            },
                shape = RoundedCornerShape(30.dp),
            )
            {
                Text(text = "Clear")
            }




        }
    }

}





@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    CalculatorTheme {
        Calculator()
    }
}