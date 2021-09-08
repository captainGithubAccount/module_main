package com.example.module_main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.module_main.databinding.ActivityMainBinding
import com.example.module_main.state.MainViewModel
import com.example.module_main.state.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var _navController: NavController

    val mainViewModel: MainViewModel by viewModels<MainViewModel> {
        MainViewModelFactory()
    }

    /*override fun onStart() {
        super.onStart()
        _navController = findNavController(R.id.nav_main_host_fragment)
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        //window?.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.window_bg))

        val navHostFragment: NavHostFragment = supportFragmentManager.findFragmentById(R.id.nav_main_host_fragment) as NavHostFragment
        _navController = navHostFragment.navController



        binding.mainViewModel = mainViewModel
        //val appBar = binding.topAppBar

        //事件监听的绑定
        val drawerLayout: DrawerLayout = binding.drawerLayout
//        顶部导航菜单图标的点击事件
        binding.navigationOnclickListener = MainViewModel.NavigationOnClickListener(drawerLayout)

        binding.navigationItemSelectedListener = MainViewModel.NavigationItemSelectedListener(_navController,drawerLayout, this, binding)
        binding.motionLayoutOnClickListener = MainViewModel.MotionLayoutOnClickListener(binding, _navController)


    }
}