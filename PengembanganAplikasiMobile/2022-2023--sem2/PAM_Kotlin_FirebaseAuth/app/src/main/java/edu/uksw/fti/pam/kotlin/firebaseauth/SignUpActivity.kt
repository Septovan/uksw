package edu.uksw.fti.pam.kotlin.firebaseauth

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import edu.uksw.fti.pam.kotlin.firebaseauth.ui.theme.PAMKotlinFirebaseAuthTheme

class SignUpActivity : ComponentActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        setContent {
            PAMKotlinFirebaseAuthTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SignUpScreen(onClickAction = ::sendUsernameBackToLoginPage)
                }
            }
        }
    }

    private fun sendUsernameBackToLoginPage(
        nama: String?,
        username: String?,
        password: String?
    ) {

        auth.createUserWithEmailAndPassword(username!!, password!!)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val result = Intent().putExtra("username", username)

                    setResult(Activity.RESULT_OK, result)
                    finish()
                } else {
                    Toast.makeText(applicationContext, "Error Create User", Toast.LENGTH_SHORT).show()
                }
            }
    }
}

@Composable
fun SignUpScreen(
    onClickAction: (String, String, String) -> Unit
) {
    var namaInput by remember { mutableStateOf("") }
    var usernameInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        TextField(
            value = namaInput,
            onValueChange = { namaInput = it },
            label = { Text(text = "Nama") }
        )
        TextField(
            value = usernameInput,
            onValueChange = { usernameInput = it },
            label = { Text(text = "Username") }
        )
        TextField(
            value = passwordInput,
            onValueChange = { passwordInput = it },
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation()
        )
        Button(
            onClick = { onClickAction(namaInput, usernameInput, passwordInput) }
        ) {
            Text(text = "SUBMIT")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    //SignUpScreen()
}