package com.example.prg1;
import android.os.Bundle;
import android.content.res.Configuration;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView msg = findViewById(R.id.orientationMessage);

        // Check orientation and set message
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            msg.setText("Landscape Mode");
        } else if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            msg.setText("Portrait Mode");
        } else {
            msg.setText("Unknown Orientation");
        }
    }
}
