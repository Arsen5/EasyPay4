package com.example.easypay

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.auth)
        var sp = getSharedPreferences("TY", Context.MODE_PRIVATE)
        val email: EditText = findViewById(R.id.email)
        val password: EditText = findViewById(R.id.password)
        val auth: Button = findViewById(R.id.button)
        val to_reg: Button = findViewById(R.id.button2)
        var db = Firebase.firestore
        var df = false
        auth.setOnClickListener{
            if (email.text.isEmpty() || password.text.isEmpty()) {
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            }
            else {
                db.collection("users")
                    .get()
                    .addOnSuccessListener { result ->
                        for (document in result) {
                            if(document.getString("email")==email.text.toString()){
                                if(document.getString("password")==password.text.toString()){
                                    sp.edit().putString("Email", email.text.toString()).commit()
                                    startActivity(Intent(this, StartActivity::class.java))
                                }
                            }
                            else{
                                Toast.makeText(this, "пользователь не найден", Toast.LENGTH_LONG).show()
                            }

                        }
                    }
                    .addOnFailureListener { exception ->
                        Toast.makeText(this, "Что-то пошло не так(", Toast.LENGTH_LONG).show()
                    }
            }
        }
        to_reg.setOnClickListener {
            startActivity(Intent(this, RegActivity::class.java))
        }
    }
}