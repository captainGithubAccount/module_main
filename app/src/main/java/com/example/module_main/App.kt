package com.example.module_main

import android.app.Application
import android.content.Context
import com.airbnb.lottie.Lottie
import com.airbnb.lottie.LottieConfig

class App: Application() {

    companion object{
        lateinit var  context: Context
    }
    override fun onCreate() {
        super.onCreate()
        context = applicationContext

    }
}