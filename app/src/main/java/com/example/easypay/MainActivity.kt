package com.example.easypay

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sp = getSharedPreferences("PC", Context.MODE_PRIVATE)
        if(sp.getString("TY", "-9")!="-9") {
            startActivity(Intent(this, StartActivity::class.java))
        }
        else{
            startActivity(Intent(this, FirstActivity::class.java))
        }
    }
}