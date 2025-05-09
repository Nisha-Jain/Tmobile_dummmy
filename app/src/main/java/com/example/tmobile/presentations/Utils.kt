package com.example.tmobile.presentations

import android.util.Patterns

object Utils {

    fun String.isValidEmail():Boolean{
        return Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }

    fun String.isValidPassword():Boolean{
        val regex= Regex("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$")
        return this.matches(regex)
    }

}