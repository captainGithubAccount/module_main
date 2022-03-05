package com.example.module_main

import android.app.Application
import android.content.Context
import com.example.module_main.moudle_word.AppDatabase
import com.example.module_main.moudle_word.WordRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class App: Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { AppDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { WordRepository(database.wordDao()) }

    companion object{
        lateinit var  context: Context
    }
    override fun onCreate() {
        super.onCreate()
        context = applicationContext

    }
}