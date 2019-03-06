package com.example.recyclerview

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class DigitalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_digital)

        val textView = findViewById<TextView>(R.id.tvdigital)
        val intent = intent
        val s = intent.getStringExtra("namedigital")
        Log.d("log", "" + s)
        textView.text = s

    }
}
