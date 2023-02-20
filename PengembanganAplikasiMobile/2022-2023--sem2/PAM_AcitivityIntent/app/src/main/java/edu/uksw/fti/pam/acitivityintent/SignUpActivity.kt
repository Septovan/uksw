package edu.uksw.fti.pam.acitivityintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.uksw.fti.pam.acitivityintent.ui.theme.PAMAcitivityIntentTheme

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PAMAcitivityIntentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SignUpForm()
                }
            }
        }
    }
}
@Composable
fun SignUpForm() {
    var usernameInput by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TextField(
            value = usernameInput,
            onValueChange = { usernameInput = it },
            label = { Text(text = stringResource(id = R.string.label_username)) },
            modifier = Modifier.fillMaxWidth(),
        )
        Button(
            onClick = { /*TODO*/ }
        ) {
            Text(stringResource(R.string.btn_label_ok))
        }
    }
}
@Preview(showBackground = true)
@Composable
fun SignUpFormPreview() {
    PAMAcitivityIntentTheme {
        SignUpForm()
    }
}