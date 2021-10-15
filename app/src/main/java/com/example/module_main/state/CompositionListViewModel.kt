package com.example.module_main.state

import android.util.Log
import android.widget.Toast
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.module_main.App
import com.example.module_main.data.api.NewsApi.newsApiService
import com.example.module_main.data.api.NewsApiService
import com.example.module_main.data.bean.BASE_URL_COMPOSITION_CONTENT
import com.example.module_main.data.bean.BASE_URL_INFO_COMPOSITION
import com.example.module_main.data.bean.CompositionInfo
import com.example.module_main.data.bean.ResultComposition
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeout

class CompositionListViewModel(private val compositionParameter: String, private val newsApiService: NewsApiService): ViewModel() {
    private var _compositionInfo: MutableLiveData<List<CompositionInfo>> = MutableLiveData<List<CompositionInfo>>()
    val compositionInfo: LiveData<List<CompositionInfo>> get() = _compositionInfo

    private var _compositionResult: MutableLiveData<ResultComposition> = MutableLiveData<ResultComposition>()
    val compositionResult: LiveData<ResultComposition> get() = _compositionResult

    init{

        getComposition(compositionParameter)
        Log.d("DDD_URL_LIST_INITIAL", compositionInfo.value.toString())
        Log.d("DDD_URL_LIST_INITIAL", _compositionInfo.value.toString())

    }

    @WorkerThread
    fun getComposition(contentId: String){
        val urlWithParameter: String = "${BASE_URL_INFO_COMPOSITION}${contentId}"
        Log.d("DDD_URL", urlWithParameter)
        viewModelScope.launch {
            val result = newsApiService.sendRequestGetCompositions(urlWithParameter).result
            if(result != null){
                _compositionResult.value =result!!
                Log.d("DDD_URL", _compositionResult.value.toString())

                _compositionInfo.value = result.list
                Log.d("DDD_URL", _compositionInfo.value.toString())
            }else{
                Toast.makeText(App.context, "今天的composition list api免费次数已经用完，明天再来吧", Toast.LENGTH_SHORT).show()
            }

        }

    }



}