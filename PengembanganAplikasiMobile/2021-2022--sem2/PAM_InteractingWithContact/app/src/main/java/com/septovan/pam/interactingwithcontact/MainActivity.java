package com.septovan.pam.interactingwithcontact;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final int REQ_CODE_SHOW_CONTACT = 1;
    private final int PERMISSION_SHOW_CONTACT = 2;

    private Button btnShowContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowContact = findViewById(R.id.btn_show_contact);

        String[] permissions = { Manifest.permission.READ_CONTACTS };

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(this, permission)
                        != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(this,
                            permissions,
                            PERMISSION_SHOW_CONTACT);
                }
            }
        }

        btnShowContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showContactIntent = new Intent(
                        Intent.ACTION_PICK,
                        ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(showContactIntent, REQ_CODE_SHOW_CONTACT);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSION_SHOW_CONTACT) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQ_CODE_SHOW_CONTACT) {
            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Operation Failed", Toast.LENGTH_SHORT).show();
            }
            else if (resultCode == RESULT_OK) {
                final String[] projections = { ContactsContract.Contacts.DISPLAY_NAME };

                Cursor cursor = getContentResolver().query(
                    data.getData(),
                    projections,
                    null,
                    null,
                    null
                );

                if (cursor != null) {
                    if (cursor.moveToFirst()) {
                        String name = cursor.getString(
                            cursor.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME)
                        );

                        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(this,
                                "Can not access the data due to permission issue",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
            else {
                Toast.makeText(this, "Unknown Error", Toast.LENGTH_SHORT).show();
            }
        }
    }
}