package edu.uksw.fti.pam.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var viewTextHello: TextView
    private lateinit var editTextUsername: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewTextHello = findViewById(R.id.textView)
        editTextUsername = findViewById(R.id.editTextTextPersonName)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.containedButton)

        viewTextHello.setText("Hello PAM")

        buttonLogin.setOnClickListener(View.OnClickListener {
            val username = editTextUsername.text
            viewTextHello.setText("Hello $username!")
        })
    }
}