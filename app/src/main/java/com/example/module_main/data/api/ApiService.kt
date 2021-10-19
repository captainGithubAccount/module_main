package com.example.module_main.data.api


import android.util.Log
import android.widget.Toast
import com.example.module_main.App
import com.example.module_main.data.bean.*
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import java.lang.Exception

class ApiService {
    val okHttpClient: OkHttpClient by lazy{OkHttpClient()}
    init {
        //Log.d("TestResponse---", "NewsApiService初始化了...")
    }

    companion object{
        //使用gson框架将返回的json格式数据转为newsBean对象
        fun jsonToNewsObject(jsonString: String?): NewsBean = Gson().fromJson(jsonString, NewsBean::class.java)

        //使用gson框架将返回的json格式数据转为compositionBaseInfoList对象
        fun jsonToCompositionObject(jsonString: String?): ComPositionBaseInfoList = Gson().fromJson(jsonString, ComPositionBaseInfoList::class.java)

        //使用gson框架将返回的json格式数据转为compositionContentInfo对象
        fun jsonToCompositionContentInfoObject(jsonString: String?): CompositionContentInfo = Gson().fromJson(jsonString, CompositionContentInfo::class.java)

    }

    //发送get请求获取新闻数据
    suspend fun sendRequestGetNews(requestUrl: String): NewsBean? {
        Log.d("TestResponse---", "走了Api下的发送请求方法,---url参数为:${requestUrl}")
        var jsonResponse: String? = null
        withContext(Dispatchers.IO) {
            val request: Request = Request.Builder()
                .url(requestUrl)
                .build()

            try {
                //Log.d("TestResponse---", "开始执行请求。。。")
                jsonResponse = okHttpClient.newCall(request).execute().body?.string()

                /*Log.d("TestResponse---", "执行请求完毕。。。")
                if(jsonResponse == null){
                    Log.d("TestResponse---", "null")
                }else{

                    Log.d("TestResponse---", jsonResponse!!)
                }*/
            } catch (e: Exception) {
                Log.d("TestResponse---", e.message!!)
            }
        }
        if(jsonResponse != null){
            return jsonToNewsObject(jsonResponse)

        }else{
            Toast.makeText(App.context,"糟糕，网络波动了，请从新申请数据把", Toast.LENGTH_SHORT).show()
            return null
        }

    }

    //发送get请求获取作文列表数据
    suspend fun sendRequestGetCompositions(requestUrl: String): ComPositionBaseInfoList? {
        //Log.d("TestResponse---", "走了Api下的发送请求方法,---url参数为:${requestUrl}")
        var jsonResponse: String? = null
        withContext(Dispatchers.IO) {
            val request: Request = Request.Builder()
                .url(requestUrl)
                .build()

            try {
                //Log.d("TestResponse---", "开始执行请求。。。")
                jsonResponse = okHttpClient.newCall(request).execute().body?.string()

                /*Log.d("TestResponse---", "执行请求完毕。。。")
                if(jsonResponse == null){
                    Log.d("TestResponse---", "null")
                }else{

                    Log.d("TestResponse---", jsonResponse!!)
                }*/
            } catch (e: Exception) {
                Log.d("TestResponse---", e.message!!)
            }
        }


        if(jsonResponse != null){
            return jsonToCompositionObject(jsonResponse)

        }else{
            Toast.makeText(App.context,"糟糕，网络波动了，请从新申请数据把", Toast.LENGTH_SHORT).show()
            return null
        }
    }

    //发送get请求获取作文数据
    suspend fun sendRequestGetCompositionContent(requestUrl: String): CompositionContentInfo? {
        Log.d("TestResponse---", "走了Api下的发送请求方法,---url参数为:${requestUrl}")
        var jsonResponse: String? = null
        withContext(Dispatchers.IO) {
            val request: Request = Request.Builder()
                .url(requestUrl)
                .build()

            try {
                //Log.d("TestResponse---", "开始执行请求。。。")
                jsonResponse = okHttpClient.newCall(request).execute().body?.string()

            } catch (e: Exception) {
                Log.d("TestResponse---", e.message!!)
            }
        }



        if(jsonResponse != null){
            return jsonToCompositionContentInfoObject(jsonResponse)
        }else{
            Toast.makeText(App.context,"糟糕，网络波动了，请从新申请数据把", Toast.LENGTH_SHORT).show()
            return null
        }
    }
}