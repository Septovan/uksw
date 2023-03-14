package edu.uksw.fti.pam.kotlin.firebase

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import edu.uksw.fti.pam.kotlin.firebase.ui.theme.PAMKotlinFIrebaseTheme
import java.io.ByteArrayOutputStream
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PAMKotlinFIrebaseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen(onSubmitActionEvent = ::uploadImage)
                }
            }
        }
    }

    private fun uploadImage(img: ImageBitmap, caption: String) {
        val fStorage = Firebase.storage
        val storageRef = fStorage.reference

        // Set file name to timestamp
        val fileName = SimpleDateFormat("yyyyMMddHHmm'.png'").format(Date())
        val ref = storageRef.child("images/$fileName")

        // convert ImageBitmap to ByteArray
        val stream = ByteArrayOutputStream()
        img.asAndroidBitmap().compress(Bitmap.CompressFormat.PNG, 100, stream)
        val image = stream.toByteArray()

        // Upload process
        var uploadTask = ref.putBytes(image)

        val urlTask = uploadTask.continueWithTask { task ->
            if (!task.isSuccessful) {
                task.exception?.let {
                    throw it
                }
            }
            ref.downloadUrl
        }.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val downloadUri = task.result
                addData(downloadUri.toString(), caption)
            } else {
                Toast.makeText(applicationContext, "Failed upload image", Toast.LENGTH_SHORT).show()
                // Handle failures
                // ...
            }
        }
    }

    private fun addData(imgUrl: String, caption: String) {
        val fFirestore = Firebase.firestore

        // Add a new document with a generated id.
        val data = hashMapOf(
            "caption" to caption,
            "imgUrl" to imgUrl
        )

        fFirestore.collection("images")
            .add(data)
            .addOnSuccessListener { documentReference ->
                Toast.makeText(applicationContext, "Added data successfuly", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(applicationContext, "Failed add data", Toast.LENGTH_SHORT).show()
            }
    }
}

@Composable
fun MainScreen(
    onSubmitActionEvent: (img: ImageBitmap, caption: String) -> Unit
) {
    val lContext = LocalContext.current
    var captionText by remember { mutableStateOf("") }
    var takenImage by remember {
        mutableStateOf(
            BitmapFactory.decodeResource(lContext.resources, R.drawable.no_image_available_svg).asImageBitmap()
        )
    }

    val takePictureContract = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview(),
        onResult = { _takenImageBitmap ->
            takenImage = _takenImageBitmap.asImageBitmap()
        }
    )

    Column(modifier = Modifier.padding(4.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                bitmap = takenImage,
                contentDescription = "",
                modifier = Modifier
                    .size(120.dp)
                    .padding(end = 8.dp)
                    .clickable {
                        takePictureContract.launch()
                    }
            )
            Column(modifier = Modifier.fillMaxWidth()) {
                TextField(value = captionText, onValueChange = { captionText = it })
                Button(onClick = {
                    onSubmitActionEvent(takenImage, captionText)
                    captionText = ""
                    takenImage = BitmapFactory.decodeResource(lContext.resources, R.drawable.no_image_available_svg).asImageBitmap()
                }) {
                    Text(text = "Submit")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    PAMKotlinFIrebaseTheme {
        // MainScreen()
    }
}