package com.example.yourapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);   // Load your layout

        // Your code to populate Spinner, ListView, and AutoCompleteTextView goes here:

        Spinner spinner = findViewById(R.id.spinnerSample);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                new String[] {"Item 1", "Item 2", "Item 3"});
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        ListView listView = findViewById(R.id.listViewSample);
        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                new String[] {"List 1", "List 2", "List 3", "List 4"});
        listView.setAdapter(listAdapter);

        AutoCompleteTextView autoComplete = findViewById(R.id.autoCompleteSample);
        ArrayAdapter<String> autoAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line,
                new String[] {"Apple", "Banana", "Carrot", "Date"});
        autoComplete.setAdapter(autoAdapter);
    }
}
