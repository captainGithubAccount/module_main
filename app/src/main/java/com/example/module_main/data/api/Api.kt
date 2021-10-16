package com.example.module_main.data.api


object Api {
    init {
        //Log.d("TestResponse---", "NewsApi初始化...")
    }

    val API_SERVICE: ApiService by lazy {
        //Log.d("TestResponse---", "NewsApiService初始化...")
        ApiService()
    }
}
