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
            return TapRestViewModel(newsApiService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

class CompositionListViewModelFactory(val compositionParameter: String, val newsApiService: NewsApiService): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CompositionListViewModel::class.java)) {
            return CompositionListViewModel(compositionParameter,newsApiService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
class CompositionContentViewModelFactory(val compositionContentUrlParameter: String, val newsApiService: NewsApiService): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CompositionContentViewModel::class.java)) {
            return CompositionContentViewModel(compositionContentUrlParameter, newsApiService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

