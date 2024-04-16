package com.example.easypay

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first)
        val auth: Button = findViewById(R.id.btn1)
        val reg: Button = findViewById(R.id.btn2)
        auth.setOnClickListener {
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }
        reg.setOnClickListener {
            val intent = Intent(this, RegActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onBackPressed() {
    }
}