package com.example.easypay

class CustomCode {
    private val characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"

    fun generator(length: Int, specialWord: String = ""): String {

        val sb = StringBuilder(length)

        for(x in 0 until length) {
            val random = (characters.indices).random()
            sb.append(characters[random])
        }

        sb.insert((0 until length).random(), specialWord)
        return sb.toString()
    }
}