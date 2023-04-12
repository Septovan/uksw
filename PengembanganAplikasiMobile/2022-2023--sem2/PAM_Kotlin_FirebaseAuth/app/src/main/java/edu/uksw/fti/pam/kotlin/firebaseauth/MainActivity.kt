package edu.uksw.fti.pam.kotlin.firebaseauth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import edu.uksw.fti.pam.kotlin.firebaseauth.contract.SignUpContract
import edu.uksw.fti.pam.kotlin.firebaseauth.ui.theme.PAMKotlinFirebaseAuthTheme

class MainActivity : ComponentActivity() {
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
                    LoginScreen(onSignInAction = ::doAuth)
                }
            }
        }
    }

    private fun doAuth(username: String, password: String) {
        auth.signInWithEmailAndPassword(username, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    startActivity(
                        Intent(this, HomeActivity::class.java)
                    )

                    finish()
                } else {
                    Toast.makeText(applicationContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }
}

@Composable
fun LoginScreen(
    onSignInAction: (String, String) -> Unit
) {
    var usernameInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }

    var getUsernameFromSignUp = rememberLauncherForActivityResult(
        contract = SignUpContract(),
        onResult = { username -> {
                usernameInput = username!!
            }
        }
    )

    Column(
        modifier = Modifier.padding(10.dp)
    ) {
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
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Button(onClick = {
                onSignInAction(usernameInput, passwordInput)
            }) {
                Text(text = "Sign In")
            }
            Button(onClick = {
                getUsernameFromSignUp.launch("")
            }) {
                Text(text = "Sign Up")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    // LoginScreen()
}