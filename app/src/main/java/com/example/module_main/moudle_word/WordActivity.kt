package com.example.module_main.moudle_word

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import com.example.module_main.R
import com.example.module_main.databinding.ActivityWordBinding

class WordActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityWordBinding = DataBindingUtil.setContentView(this, R.layout.activity_word)
    }

    //监听点击action bar回退按钮操作
    override fun onSupportNavigateUp(): Boolean {
        /*
        * @ param R.id.nav_word: 指放nav_graph的viewGroup的id
        * */
        return Navigation.findNavController(findViewById(R.id.nav_word)).navigateUp() or super.onSupportNavigateUp()
    }

    //当按下手机自带导航栏的回退键时候, 需要出栈处理
    override fun onBackPressed() {
        super.onBackPressed()
        Navigation.findNavController(findViewById(R.id.nav_word)).navigateUp()

    }
}