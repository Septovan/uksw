package com.septovan.pam.pam_differentdevices;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextView txtLogin, txtWelcome;
    private TextInputLayout txtInputUsername, txtInputPassword;
    private Button btnLogin, btnToSignup;

    private final int REQ_CODE_SIGNUPACTIVITY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLogin = findViewById(R.id.txtLogin);
        txtWelcome = findViewById(R.id.txtWelcome);
        txtInputUsername = findViewById(R.id.txtInputUsername);
        txtInputPassword = findViewById(R.id.txtInputPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnToSignup = findViewById(R.id.btnToSignup);

        btnToSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToSignup = new Intent(MainActivity.this, SignUpActivity.class);
                startActivityForResult(intentToSignup, REQ_CODE_SIGNUPACTIVITY);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQ_CODE_SIGNUPACTIVITY) {
            if (resultCode == Activity.RESULT_OK) {
                String username = data.getStringExtra("username");
                txtInputUsername.getEditText().setText(username);
            }
            else {
                Toast.makeText(this,
                        "Error when receiving data from SignUpActivity",
                        Toast.LENGTH_LONG)
                    .show();
            }
        }
    }
}