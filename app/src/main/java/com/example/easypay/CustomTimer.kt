package com.example.easypay

import android.os.CountDownTimer

open class CustomTimer(
    private val millisInFuture : Long,
    private val countDownInterval: Long
) {

    private var millisUntilFinished = millisInFuture
    private var timer = IntervalTimer(this, millisInFuture, countDownInterval)
    private var isRunning = false
    var onTick: ((millisUntilFinished:Long) -> Unit)? = null
    var onFinish: (() -> Unit)? = null



    private class IntervalTimer(
        private val parent: CustomTimer,
        millisInFuture: Long,
        countDownInterval: Long
    ): CountDownTimer(millisInFuture, countDownInterval) {

        var millisUntilFinished = parent.millisUntilFinished
        override fun onTick(millisUntilFinished: Long) {
            this.millisUntilFinished = millisUntilFinished
            parent.onTick?.invoke(millisUntilFinished)
        }

        override fun onFinish() {
            millisUntilFinished = 0
            parent.onFinish?.invoke()
        }

    }

    fun startTimer(){
        timer.start()
    }
    fun restartTimer() {
        timer.cancel()
        timer = IntervalTimer(this, millisInFuture, countDownInterval)
        startTimer()
    }
}