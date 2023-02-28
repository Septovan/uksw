package edu.uksw.fti.pam.kotlininteractingwithcontact

import android.os.Bundle
import android.provider.ContactsContract
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import edu.uksw.fti.pam.kotlininteractingwithcontact.ui.theme.PAMKotlinInteractingWithContactTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PAMKotlinInteractingWithContactTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    val context = LocalContext.current
    var contactDisplayName by remember{ mutableStateOf("") }

    val getContactData = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickContact(),
        onResult ={ data ->
            val projections = arrayOf(
                ContactsContract.Contacts.DISPLAY_NAME
            )

            val cursor = context.contentResolver.query(
                data!!,
                projections,
                null,
                null,
                null
            )
            cursor?.moveToFirst()

            val displayNameIndex = cursor?.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)
            val displayName = cursor?.getString(displayNameIndex!!)

            contactDisplayName = displayName!!
        }
    )

    Column {
        Button(
            onClick = { getContactData.launch() }
        ) {
            Text(text = "Get Contact")
        }
        Text(text = contactDisplayName)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PAMKotlinInteractingWithContactTheme {
        MainScreen()
    }
}