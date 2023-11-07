package com.example.jetpackcompose



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    ExploreButtonScreen()
                }
            }
        }
    }
}

@Composable
fun ExploreButtonScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        MyButton()
        MyRadioGroup()
        MyFloatingActionButton()
        LinearProgressIndicatorSample()
        ProgressIndicatorScreen()
        MyAlertDialog()
    }
}

@Composable
fun MyButton() {
    // TODO Add your code here
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
        border = BorderStroke(
            1.dp,
            color = Color.Black),
    ) {
        Text(
            text = stringResource(
                id = R.string.button_text
            ),
            color = Color.White)
    }
}

@Composable
fun MyRadioGroup() {
    val radioButtons = listOf(0, 1, 2) // 1
    val selectedButton = remember { mutableStateOf(radioButtons.first()) } // 2
    Column {
        radioButtons.forEach { index -> // 3
            val isSelected = index == selectedButton.value
            val colors = RadioButtonDefaults.colors(
                // 4
                selectedColor = Color.Red,
                unselectedColor = Color.Blue,
                disabledUnselectedColor = Color.LightGray,
                disabledSelectedColor = Color.Red
            )
            RadioButton( // 5
                colors = colors,
                selected = isSelected,
                onClick = { selectedButton.value = index }
            )
        }
    }
}

@Composable
fun MyFloatingActionButton() {
    // TODO Add your code here
    FloatingActionButton(
        onClick = { /*TODO*/ },
        containerColor = Color.Red,
        contentColor = Color.White,
        content = {
            Icon(Icons.Filled.Favorite, contentDescription = "Test FAB")
        }
    )
}

@Composable
fun ProgressIndicatorScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // TODO add your code here ...
        CircularProgressIndicator(
            color = MaterialTheme.colorScheme.primary,
            strokeWidth = 5.dp
        )
        Spacer(modifier = Modifier.padding(10.dp))
        LinearProgressIndicator(progress = 0.5f)
    }
}

@Composable
fun LinearProgressIndicatorSample() {
    var progress by remember { mutableStateOf(0.1f) }
    val animatedProgress = animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec, label = ""
    ).value

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Spacer(Modifier.height(30.dp))
        Text("LinearProgressIndicator with undefined progress")
        LinearProgressIndicator()
        Spacer(Modifier.height(30.dp))
        Text("LinearProgressIndicator with progress set by buttons")
        LinearProgressIndicator(progress = animatedProgress)
        Spacer(Modifier.height(30.dp))
        OutlinedButton(
            onClick = {
                if (progress < 1f) progress += 0.1f
            }
        ) {
            Text("Increase")
        }

        OutlinedButton(
            onClick = {
                if (progress > 0f) progress -= 0.1f
            }
        ) {
            Text("Decrease")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExploreButtonScreenPreview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        MyButton()
        MyRadioGroup()
        MyFloatingActionButton()
        LinearProgressIndicatorSample()
        ProgressIndicatorScreen()
    }
}

@Composable
fun MyAlertDialog() {
    val shouldShowDialog = remember { mutableStateOf(true) }

    if(shouldShowDialog.value) {
        AlertDialog(
            onDismissRequest = { shouldShowDialog.value = false },
            title = { Text(text = stringResource(id = R.string.alert_dialog_title))},
            confirmButton = { 
                Button(
                    colors = ButtonDefaults.buttonColors(
                        contentColor = colorResource(id = R.color.purple_500)
                    ),
                    onClick = { shouldShowDialog.value = false }
                ) {
                    Text(
                        text = stringResource(id = R.string.confirm),
                        color = Color.White
                    )
                }
            }
        )
    }
}

















