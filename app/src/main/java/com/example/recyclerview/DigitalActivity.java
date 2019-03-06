package com.example.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DigitalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digital);

        TextView textView = findViewById(R.id.tvdigital);
        Intent intent = getIntent();
        String s = intent.getStringExtra("namedigital");
        Log.d("log",""+s);
        textView.setText(s);

    }
}
