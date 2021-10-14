package com.example.module_main.state

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.module_main.App
import com.example.module_main.data.api.NewsApi
import com.example.module_main.data.api.NewsApiService
import com.example.module_main.data.bean.Data
import com.example.module_main.data.bean.URL_REST
import kotlinx.coroutines.launch

class TapRestViewModel(private val newsApiService: NewsApiService): ViewModel() {
    private var _news: MutableLiveData<List<Data>> = MutableLiveData<List<Data>>()
    val news: LiveData<List<Data>>
        get() = _news


    init {
        getNews(URL_REST)
        //Log.d("TestResponse---", "TapRestViewModel 初始化...并访问完了网络拿到数据")
    }

    @WorkerThread
    fun getNews(requestUrl: String) {
        viewModelScope.launch {
            //Log.d("TestResponse---", "走了在协程发送请求的操作")
            val data = newsApiService.sendRequestGetNews(requestUrl).result?.data
            //注意api数据请求一天只有100次，所以可能有数据为空的情况
            if(data != null){
                _news.value = data!!
            }else{
                Toast.makeText(App.context, "今天的api免费100次已经用完，明天再来吧", Toast.LENGTH_SHORT).show()
            }

            //Log.d("TestResponse---", news.value.toString())
            //Log.d("TestResponse---", "走了在协程发送请求的操作，执行完毕")
        }

    }
}