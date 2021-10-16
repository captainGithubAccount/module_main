package com.example.module_main.state

import android.util.Log
import android.widget.Toast
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.module_main.App
import com.example.module_main.data.api.ApiService
import com.example.module_main.data.bean.CompositionInfo
import com.example.module_main.data.bean.ResultComposition
import kotlinx.coroutines.launch

class CompositionListViewModel(private val compositionParameter: String,private val compositionBaseUrl: String,private val apiService: ApiService): ViewModel() {
    private var _grade: MutableLiveData<String> = MutableLiveData<String>()
     val grade: LiveData<String> get() = _grade!!

    private var _compositionInfo: MutableLiveData<List<CompositionInfo>> = MutableLiveData<List<CompositionInfo>>()
    val compositionInfo: LiveData<List<CompositionInfo>> get() = _compositionInfo

    private var _compositionResult: MutableLiveData<ResultComposition> = MutableLiveData<ResultComposition>()
    val compositionResult: LiveData<ResultComposition> get() = _compositionResult

    init{
        when(compositionParameter){
            "11" -> _grade.value = "一年级"
            "12" -> _grade.value = "二年级"
            "13" -> _grade.value = "三年级"
            "14" -> _grade.value = "四年级"
            "15" -> _grade.value = "五年级"
            "16" -> _grade.value = "六年级"
        }

        getComposition(compositionParameter)
        Log.d("DDD_URL_LIST_INITIAL", compositionInfo.value.toString())
        Log.d("DDD_URL_LIST_INITIAL", _compositionInfo.value.toString())

    }

    @WorkerThread
    fun getComposition(contentId: String){
        val urlWithParameter: String = "${compositionBaseUrl}${contentId}"
        //val urlWithParameter: String = "${BASE_URL_INFO_COMPOSITION}${contentId}"
        Log.d("DDD_URL", urlWithParameter)
        viewModelScope.launch {
            val result = apiService.sendRequestGetCompositions(urlWithParameter).result
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