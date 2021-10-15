package com.example.module_main.state

import android.util.Log
import android.widget.Toast
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.module_main.App
import com.example.module_main.data.api.NewsApiService
import com.example.module_main.data.bean.BASE_URL_COMPOSITION_CONTENT
import com.example.module_main.data.bean.CompositionContent
import com.example.module_main.data.bean.CompositionInfo
import kotlinx.coroutines.launch

class CompositionContentViewModel(private val compositionContentUrlParameter: String, private val newsApiService: NewsApiService) : ViewModel() {
    private var _compositionInfo: MutableLiveData<CompositionInfo> = MutableLiveData<CompositionInfo>()
    val compositionInfo: LiveData<CompositionInfo> get() = _compositionInfo

    private var _compositionContent: MutableLiveData<CompositionContent> = MutableLiveData<CompositionContent>()
    val compositionContent: LiveData<CompositionContent> get() = _compositionContent

    init{

        getCompositionContent(compositionContentUrlParameter)
        Log.d("DDD_URL_INITIAL", _compositionContent.value.toString())
    }

    companion object{

    }
    @WorkerThread
    fun getCompositionContent(compositionContentUrlParameter: String){
        val requestUrl: String = "${BASE_URL_COMPOSITION_CONTENT}${compositionContentUrlParameter}"
        viewModelScope.launch {
            val compositionContent: CompositionContent? =
                newsApiService.sendRequestGetCompositionContent(requestUrl).result
            if(compositionContent != null){
                _compositionContent.value =compositionContent!!
                Log.d("DDD_URL_LAUNCH", _compositionContent.value.toString())

            }else{
                Toast.makeText(App.context, "今天的 composition content api免费次数已经用完，明天再来吧", Toast.LENGTH_SHORT).show()
            }

        }
    }

}