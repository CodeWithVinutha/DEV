package com.example.prg1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    private static final int REQ_READ_CONTACTS = 1;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnExplicit = findViewById(R.id.btnExplicit);
        Button btnImplicit = findViewById(R.id.btnImplicit);
        Button btnContent = findViewById(R.id.btnContent);
        tvResult = findViewById(R.id.tvResult);

        // Explicit intent: show another message in this activity
        btnExplicit.setOnClickListener(v ->
                tvResult.setText("This is a result of Explicit Intent (normally you would start another activity!)")
        );

        // Implicit intent: open a website in the browser
        btnImplicit.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.example.com"));
            startActivity(intent);
        });

        // Content Provider: show contacts
        btnContent.setOnClickListener(v -> {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, REQ_READ_CONTACTS);
            } else {
                showContacts();
            }
        });
    }

    // Handle contacts permission result
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQ_READ_CONTACTS && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            showContacts();
        } else {
            tvResult.setText("Permission denied to read contacts.");
        }
    }

    // Display contacts in the TextView
    private void showContacts() {
        StringBuilder builder = new StringBuilder();
        Cursor cursor = getContentResolver().query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                String name = cursor.getString(
                        cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String number = cursor.getString(
                        cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                builder.append(name).append(": ").append(number).append("\n");
            } while (cursor.moveToNext());
            cursor.close();
        } else {
            builder.append("No contacts found.");
        }
        tvResult.setText(builder.toString());
    }
}
