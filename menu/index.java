package com.example.yourapp; // Change to your actual package name

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Your layout XML (e.g., activity_main.xml)
    }

    // Inflate the menu resource into the app's menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu); // menu_main.xml in res/menu
        return true;
    }

    // Handle what happens when a menu item is selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show();
            // TODO: Open Settings screen or other logic
            return true;
        } else if (id == R.id.action_about) {
            Toast.makeText(this, "About clicked", Toast.LENGTH_SHORT).show();
            // TODO: Show About dialog or activity
            return true;
        } else if (id == R.id.action_exit) {
            // Exit the app (finish current Activity)
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
