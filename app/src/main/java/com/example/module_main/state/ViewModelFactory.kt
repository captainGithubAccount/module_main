package com.example.module_main.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.module_main.data.api.NewsApi
import com.example.module_main.data.api.NewsApiService

class MainViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

class TapRestViewModelFactory(val newsApiService: NewsApiService): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TapRestViewModel::class.java)) {
            return TapRestViewModel(NewsApi.newsApiService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

class CompositionViewModelFactory(val compositionParameter: String,val newsApiService: NewsApiService): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CompositionViewModel::class.java)) {
            return CompositionViewModel(compositionParameter,NewsApi.newsApiService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}