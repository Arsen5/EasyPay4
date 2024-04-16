package com.example.easypay

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseUserMetadata
import com.google.firebase.firestore.firestore


class RegActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var sp = getSharedPreferences("PC", Context.MODE_PRIVATE).edit()
        setContentView(R.layout.reg)
        val email: EditText = findViewById(R.id.email_reg)
        val name: EditText = findViewById(R.id.name)
        val pass: EditText = findViewById(R.id.pass_reg)
        val passcheck: EditText = findViewById(R.id.pass_dbl)
        val button: Button = findViewById(R.id.reg)
        val button_toauth: Button = findViewById(R.id.button3)
        val db = Firebase.firestore
        button.setOnClickListener {
            if(email.text.isEmpty() || name.text.isEmpty() || pass.text.isEmpty() || passcheck.text.isEmpty()){
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            }
            else if(pass.text.toString() != passcheck.text.toString()){
                Toast.makeText(this, "Пароли не совпадают", Toast.LENGTH_LONG).show()
            }
            else if(pass.text.length < 6) {
                Toast.makeText(this, "Пароль должен быть не менее 5 символов", Toast.LENGTH_LONG).show()
            }
            else{
                val user = hashMapOf(
                    "email" to email.text.toString(),
                    "password" to pass.text.toString(),
                    "name" to name.text.toString()
                )
                db.collection("users")
                    .add(user)
                    .addOnSuccessListener { documentReference ->
                        sp.putString("Email", email.text.toString()).commit()
                        startActivity(Intent(this, StartActivity::class.java))
                    }
                    .addOnFailureListener { e ->
                        Toast.makeText(this, "Что-то пошло не так(", Toast.LENGTH_LONG).show()

                    }
                }
            }
        button_toauth.setOnClickListener {
            startActivity(Intent(this, AuthActivity::class.java))
        }

    }
}