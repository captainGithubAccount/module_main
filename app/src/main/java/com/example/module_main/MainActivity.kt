package com.example.module_main

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE
import android.view.Window
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.module_main.databinding.ActivityMainBinding
import com.example.module_main.state.MainViewModel
import com.example.module_main.state.MainViewModelFactory
import androidx.drawerlayout.widget.DrawerLayout.DrawerListener


class MainActivity : AppCompatActivity() {
    private lateinit var _navController: NavController

    //val fragmentRestBinding = FragmentRestBinding.inflate(layoutInflater)

    val mainViewModel: MainViewModel by viewModels<MainViewModel> {
        MainViewModelFactory()
    }

    /*override fun onStart() {
        super.onStart()
        _navController = findNavController(R.id.nav_main_host_fragment)
    }*/


    protected fun setStatusBarFullTransparent() {
        if (Build.VERSION.SDK_INT >= 21) { //21表示5.0
            val window = window
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or SYSTEM_UI_FLAG_LAYOUT_STABLE)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        } else if (Build.VERSION.SDK_INT >= 19) { //19表示4.4
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            //虚拟键盘也透明
            //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setStatusBarFullTransparent()





        val binding : ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        //window?.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.window_bg))

        val navHostFragment: NavHostFragment = supportFragmentManager.findFragmentById(R.id.nav_main_host_fragment) as NavHostFragment
        _navController = navHostFragment.navController



        binding.mainViewModel = mainViewModel
        //val appBar = binding.topAppBar


        val drawerLayout: DrawerLayout = binding.drawerLayout


//        顶部导航菜单图标的点击事件
        binding.navigationOnclickListener = MainViewModel.NavigationOnClickListener(drawerLayout)

        //导航栏的item点击跳转页面的监听
        binding.navigationItemSelectedListener = MainViewModel.NavigationItemSelectedListener(_navController,drawerLayout, this, binding)

        //底部navigation的点击切换碎片的监听
        binding.motionLayoutOnClickListener = MainViewModel.MotionLayoutOnClickListener(binding, _navController)


        //让左侧划出的部分宽度为全屏
        binding.navigationview.layoutParams.also {
            val width: Int = resources.displayMetrics.widthPixels
            it.width = width
        }.let {
            binding.navigationview.layoutParams = it
        }


        //仿qq抽屉菜单拖动主屏幕跟随一起拖动效果监听

        binding.drawerLayout.addDrawerListener(object : DrawerListener {
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {

                // 主页内容
                val contentView = drawerLayout.getChildAt(0)
                // 侧边栏
                // slideOffset 值默认是0~1
                contentView.translationX = drawerView.measuredWidth * slideOffset


                //侧边滑动的距离等于moon motion的progress,从而实现导航抽屉和滑动之前的motion动画
                binding.motionMainDrawerBottom.progress = slideOffset
            }

            override fun onDrawerOpened(drawerView: View) {}
            override fun onDrawerClosed(drawerView: View) {}
            override fun onDrawerStateChanged(newState: Int) {}


        })

    }


}