package com.example.easypay

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat
import kotlin.math.roundToInt


class StartActivity : AppCompatActivity() {
    private lateinit var timeText: TextView
    private lateinit var progressBar: ProgressBar

    private lateinit var customCountdownTimer: CustomTimer
    private val countdownTime = 60
    private val clockTime = (countdownTime * 1000).toLong()
    private val progressTime = (clockTime / 1000).toFloat()



    private fun timeFormat(secondsLeft: Int, timeText: TextView) {
        progressBar.progress = secondsLeft
        val decimalFormat = DecimalFormat("00")
        val sec = secondsLeft % 60

        val timeFormat1 = decimalFormat.format(secondsLeft)

        timeText.text = timeFormat1
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_frame)
        val btn: Button = findViewById(R.id.btn_tokatlg)

        val codeGenerate = CustomCode()
        val paycode: TextView = findViewById(R.id.code)


        var sp = getSharedPreferences("PC", Context.MODE_PRIVATE)
        sp.edit().putString("TY", "9").commit()
        val logout: Button = findViewById(R.id.logout)
        logout.setOnClickListener {
            sp.edit().putString("TY", "-9").commit()
            startActivity(Intent(this, FirstActivity::class.java))
        }


        var secondsLeft = 0

        timeText = findViewById(R.id.time)
        progressBar = findViewById(R.id.circular)

        val passcode = codeGenerate.generator(8, "")
        paycode.text = passcode

        val bubl = Bundle()

        customCountdownTimer = object : CustomTimer(clockTime, 1000) {}
        customCountdownTimer.onTick = {millisUntilFinished ->
            val sec = (millisUntilFinished / 1000.0f).roundToInt()
            if (sec != secondsLeft){
                secondsLeft = sec
                if (secondsLeft == 1) {
                    customCountdownTimer.restartTimer()
                    val passcode = codeGenerate.generator(8, "")
                    paycode.text = passcode
                }

                timeFormat(
                    secondsLeft,
                    timeText
                )
            }

        }
        customCountdownTimer.onFinish = {
            timeFormat(
                0,
                timeText
            )

        }
        progressBar.max = progressTime.toInt()


        progressBar.progress = progressTime.toInt()
        customCountdownTimer.startTimer()

        btn.setOnClickListener {
            bubl.putString("code", paycode.text.toString())
            val intent = Intent(this, KatalogActivity::class.java)
            intent.putExtras(bubl)
            startActivity(intent)
        }

    }

    override fun onBackPressed() {
    }
}