package com.example.easypay

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class KatalogActivity : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.katalog)

        val btn1: Button = findViewById(R.id.btnFlows)
        val btn2: Button = findViewById(R.id.btnClocks)
        val btn3: Button = findViewById(R.id.btnPhone)
        val btn4: Button = findViewById(R.id.btnBurger)
        val btn5: Button = findViewById(R.id.btnRing)
        val btn6: Button = findViewById(R.id.btnRobot)

        val n1: TextView = findViewById(R.id.textView9)
        val n2: TextView = findViewById(R.id.n2)
        val n3: TextView = findViewById(R.id.n3)
        val n4: TextView = findViewById(R.id.n4)
        val n5: TextView = findViewById(R.id.n5)
        val n6: TextView = findViewById(R.id.n6)

        var monitor: TextView = findViewById(R.id.monitor)

        val p1 = 4500
        val p2 = 5000
        val p3 = 15000
        val p4 = 200
        val p5 = 20000
        val p6 = 18000



        val bubl = intent.extras
        val bundle = Bundle()
        val gupl = Bundle()

        if (bubl != null){
            monitor.text = bubl.getString("code")
        }




        btn1.setOnClickListener {
            val b = 1
            bundle.putString("name1", n1.text.toString())
            bundle.putString("price1", p1.toString())
            bundle.putString("btn", b.toString())
            gupl.putString("cod", monitor.toString())
            val intent = Intent(this, PayActivity::class.java)
            intent.putExtras(bundle)
            intent.putExtras(gupl)
            startActivity(intent)
        }
        btn2.setOnClickListener {
            val b = 2
            bundle.putString("name2", n2.text.toString())
            bundle.putString("price2", p2.toString())
            bundle.putString("btn", b.toString())
            gupl.putString("cod", monitor.toString())
            val intent = Intent(this, PayActivity::class.java)
            intent.putExtras(bundle)
            intent.putExtras(gupl)
            startActivity(intent)
        }
        btn3.setOnClickListener {
            val b = 3
            bundle.putString("name3", n3.text.toString())
            bundle.putString("price3", p3.toString())
            bundle.putString("btn", b.toString())
            gupl.putString("cod", monitor.toString())
            val intent = Intent(this, PayActivity::class.java)
            intent.putExtras(bundle)
            intent.putExtras(gupl)
            startActivity(intent)
        }
        btn4.setOnClickListener {
            val b = 4
            bundle.putString("name4", n4.text.toString())
            bundle.putString("price4", p4.toString())
            bundle.putString("btn", b.toString())
            gupl.putString("cod", monitor.toString())
            val intent = Intent(this, PayActivity::class.java)
            intent.putExtras(bundle)
            intent.putExtras(gupl)
            startActivity(intent)
        }
        btn5.setOnClickListener {
            val b = 5
            bundle.putString("name5", n5.text.toString())
            bundle.putString("price5", p5.toString())
            bundle.putString("btn", b.toString())
            gupl.putString("cod", monitor.toString())
            val intent = Intent(this, PayActivity::class.java)
            intent.putExtras(bundle)
            intent.putExtras(gupl)
            startActivity(intent)
        }
        btn6.setOnClickListener {
            val b = 6
            bundle.putString("name6", n6.text.toString())
            bundle.putString("price6", p6.toString())
            bundle.putString("btn", b.toString())
            gupl.putString("cod", monitor.toString())
            val intent = Intent(this, PayActivity::class.java)
            intent.putExtras(bundle)
            intent.putExtras(gupl)
            startActivity(intent)
        }




    }
}