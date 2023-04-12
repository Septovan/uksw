package edu.uksw.fti.pam.kotlin.firebaseauth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import edu.uksw.fti.pam.kotlin.firebaseauth.ui.theme.PAMKotlinFirebaseAuthTheme
import edu.uksw.fti.pam.kotlin.firebaseauth.viewmodel.UserProfileViewModel

class HomeActivity : ComponentActivity() {
    private lateinit var _auth: FirebaseAuth
    private lateinit var _db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _auth = Firebase.auth
        _db = Firebase.firestore
        val vm = UserProfileViewModel()

        setContent {
            PAMKotlinFirebaseAuthTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting(vm)
                }
            }
        }
    }
}

@Composable
fun Greeting(vm: UserProfileViewModel) {
    LaunchedEffect(
        Unit,
        block = {
            vm.getLoggedInUserProfile()
        }
    )

    Text(text = "Hello ${vm.userProfile.nama}!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PAMKotlinFirebaseAuthTheme {
        // Greeting()
    }
}