package com.example.module_main.data.api

import android.util.Log


object NewsApi {
    init {
        //Log.d("TestResponse---", "NewsApi初始化...")
    }

    val newsApiService: NewsApiService by lazy {
        //Log.d("TestResponse---", "NewsApiService初始化...")
        NewsApiService()
    }
}
