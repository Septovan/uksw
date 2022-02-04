package com.septovan.pam.layoutactivityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextView txtLogin;
    private TextInputLayout txtInputUsername, txtInputPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLogin = findViewById(R.id.txtLogin);
        txtInputUsername = findViewById(R.id.txtInputUsername);
        txtInputPassword = findViewById(R.id.txtInputPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user;
                user = txtInputUsername.getEditText().getText().toString();

                Intent intentToHome = new Intent(
                        MainActivity.this,
                        HomeActivity.class);
                intentToHome.putExtra("user", user);
                startActivity(intentToHome);
            }
        });
    }
}