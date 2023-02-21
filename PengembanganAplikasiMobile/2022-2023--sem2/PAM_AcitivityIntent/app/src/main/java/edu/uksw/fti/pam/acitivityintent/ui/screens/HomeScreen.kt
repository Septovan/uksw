package edu.uksw.fti.pam.acitivityintent.ui.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import edu.uksw.fti.pam.acitivityintent.ui.theme.PAMAcitivityIntentTheme


@Composable
fun HomeScreen(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PAMAcitivityIntentTheme {
        Greeting("Android")
    }
}