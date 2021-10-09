package com.example.module_main.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.module_main.data.api.NewsApi.newsApiService
import com.example.module_main.data.api.NewsApiService


class TapRestViewModelFactory(newsApiService: NewsApiService): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TapRestViewModel::class.java)) {
            return TapRestViewModel(newsApiService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}