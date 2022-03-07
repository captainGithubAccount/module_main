package com.example.module_main

import android.app.Application
import android.content.Context
import com.example.module_main.moudle_word.AppDatabase
import com.example.module_main.moudle_word.WordRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import cn.leancloud.LeanCloud

class App: Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { AppDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { WordRepository(database.wordDao()) }

    companion object{
        lateinit var  context: Context
    }
    override fun onCreate() {
        super.onCreate()
        context = applicationContext

        // 提供 this、App ID、App Key、Server Host 作为参数
        // 注意这里千万不要调用 cn.leancloud.core.LeanCloud 的 initialize 方法，否则会出现 NetworkOnMainThread 等错误。
        LeanCloud.initialize(this,
            "NkrjjKS7CizSKhWCdMIyGInN-gzGzoHsz",
            "xoW4JY0yi9VGcHAKnWgIWPdQ",
            "https://nkrjjks7.lc-cn-n1-shared.com");

        //测试是否可以使用LeanCloud服务
        /* val testObject = LCObject("TestObject")
         testObject.put("words", "Hello world!")
         testObject.saveInBackground().blockingSubscribe()*/

    }
}