package com.septovan.pam.layoutactivityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private TextView txtHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        txtHello = findViewById(R.id.txtHello);

        String user;
        Intent intent = getIntent();
        user = intent.getStringExtra("user");

        txtHello.setText(
                txtHello.getText().toString()
                        .replace("[NAME]", user)
        );
    }
}