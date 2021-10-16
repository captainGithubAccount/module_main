package com.example.module_main.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.module_main.data.api.ApiService

class MainViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

class TapRestViewModelFactory(val urlParameter: String,val apiService: ApiService): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TapRestViewModel::class.java)) {
            return TapRestViewModel(urlParameter,apiService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

class CompositionListViewModelFactory(val compositionParameter: String, val compositionBaseUrl: String,val apiService: ApiService): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CompositionListViewModel::class.java)) {
            return CompositionListViewModel(compositionParameter,compositionBaseUrl,apiService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
class CompositionContentViewModelFactory(val compositionContentUrlParameter: String, val apiService: ApiService): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CompositionContentViewModel::class.java)) {
            return CompositionContentViewModel(compositionContentUrlParameter, apiService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

