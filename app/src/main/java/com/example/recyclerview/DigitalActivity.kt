package com.example.recyclerview

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.recyclerview.model.ApiGitHub
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_digital.*

class DigitalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_digital)

        val textView = findViewById<TextView>(R.id.tvdigital)
        val intent = intent
        val s = intent.getStringExtra("namedigital")
        val i = intent.getIntExtra("position", 0)
        val urlavt = intent.getStringExtra("urlavatar")
        Log.d("log", "" + s + i)
        textView.text = s
        Picasso.with(this)
                .load(urlavt)
                .into(imageViewgigital)



    }
}
