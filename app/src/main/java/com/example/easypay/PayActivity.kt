package com.example.easypay

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PayActivity: AppCompatActivity() {




    @SuppressLint("CutPasteId", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pay)

        val name: TextView = findViewById(R.id.name)
        val price: TextView = findViewById(R.id.price)
        var cod: EditText = findViewById(R.id.editText_code)
        var congr: TextView = findViewById(R.id.congr)
        val pay: Button = findViewById(R.id.go)

        val bundle = intent.extras
        val gupl = intent.extras

        if (bundle != null){
            if (bundle.getString("btn") == "1"){
                name.text = bundle.getString("name1")
                price.text = bundle.getString("price1")
            }
            if (bundle.getString("btn") == "2"){
                name.text = bundle.getString("name2")
                price.text = bundle.getString("price2")

            }
            if (bundle.getString("btn") == "3"){
                name.text = bundle.getString("name3")
                price.text = bundle.getString("price3")

            }
            if (bundle.getString("btn") == "4"){
                name.text = bundle.getString("name4")
                price.text = bundle.getString("price4")

            }
            if (bundle.getString("btn") == "5"){
                name.text = bundle.getString("name5")
                price.text = bundle.getString("price5")

            }
            if (bundle.getString("btn") == "6"){
                name.text = bundle.getString("name6")
                price.text = bundle.getString("price6")

            }
        }
        pay.setOnClickListener {
            congr.text = "Спасибо за покупку!"
        }
    }
}
