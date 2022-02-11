package com.septovan.pam.pam_differentdevices;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class SignUpActivity extends AppCompatActivity {

    private TextInputLayout txtInputSignupUsername;
    private Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        txtInputSignupUsername = findViewById(R.id.txtInputSignupUsername);
        btnSignup = findViewById(R.id.btnSignup);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = txtInputSignupUsername.getEditText().getText().toString();
                Intent intentResult = new Intent();
                intentResult.putExtra("username", username);
                setResult(Activity.RESULT_OK, intentResult);
                finish();
            }
        });
    }
}