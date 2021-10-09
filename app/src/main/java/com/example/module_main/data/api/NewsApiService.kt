package com.example.module_main.data.api


import android.net.NetworkRequest
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.module_main.data.bean.Data
import com.example.module_main.data.bean.NewsBean
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import java.lang.Exception
import java.lang.RuntimeException

class NewsApiService {
    val okHttpClient: OkHttpClient by lazy{OkHttpClient()}
    init {
        //Log.d("TestResponse---", "NewsApiService初始化了...")
    }

    companion object{
        //使用gson框架将返回的json格式数据转为bean对象
        fun jsonToObject(jsonString: String?): NewsBean = Gson().fromJson(jsonString, NewsBean::class.java)

    }

    //发送get请求获取聚合数据
    suspend fun sendRequestGetNews(requestUrl: String): NewsBean {
        Log.d("TestResponse---", "走了Api下的发送请求方法,---url参数为:${requestUrl}")
        var jsonResponse: String? = null
        withContext(Dispatchers.IO) {
            val request: Request = Request.Builder()
                .url("http://v.juhe.cn/toutiao/index?key=3f64601cc5c4b59a7a3abe727a200858&type=yule")
                .build()

            try {
                Log.d("TestResponse---", "开始执行请求。。。")
                jsonResponse = okHttpClient.newCall(request).execute().body?.string()

                Log.d("TestResponse---", "执行请求完毕。。。")
                if(jsonResponse == null){
                    Log.d("TestResponse---", "null")
                }else{

                    Log.d("TestResponse---", jsonResponse!!)
                }
            } catch (e: Exception) {
                Log.d("TestResponse---", e.message!!)
            }
        }

        return jsonToObject(jsonResponse)
    }
}