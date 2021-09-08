package com.example.module_main.state

import android.app.Activity
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.module_main.R
import com.example.module_main.databinding.ActivityMainBinding
import java.security.AccessController.getContext

class MainViewModel: ViewModel() {

    /*
    * 导航抽屉菜单按钮的点击事件
    * */
    class NavigationOnClickListener(val drawerLayout: DrawerLayout){
        fun onClick(p0: View?) {
            drawerLayout.open()
        }
    }

    /*
    * 导航抽屉菜单中的菜单子项点击事件
    * */
    class NavigationItemSelectedListener(private val _navController: NavController, val drawerLayout: DrawerLayout, val context: Activity, val binding: ActivityMainBinding){
        fun onNavigationItemSelected(item: MenuItem): Boolean {

//          导航抽屉菜单的item点击水波纹效果
            val outValue = TypedValue()
            context.theme.resolveAttribute(android.R.attr.selectableItemBackground, outValue, true)
            binding.navigationview.itemBackground = context.getDrawable(outValue.resourceId)


//            导航抽屉菜单的item点击后跳转到对应的碎片
            when(item.itemId){
                R.id.item_menu_rest -> _navController.navigate(R.id.restFragment)
                R.id.item_menu_mine -> _navController.navigate(R.id.mineFragment)
                R.id.item_menu_translate -> _navController.navigate(R.id.translateFragment)
                else -> _navController.navigate(R.id.exploreFragment)

            }
            drawerLayout.close()
            return false
        }
    }

    /*
    * 底部导航点击事件
    * */
    class MotionLayoutOnClickListener(private val _binding: ActivityMainBinding, private val _navController: NavController){


        fun onClick(p0: View?) {

            Log.d("AA_TAG", p0?.id.toString())
            when(p0?.id){
//            底部导航的item点击后跳转到对应的碎片
                R.id.motion_include_rest -> _navController.navigate(R.id.restFragment)
                R.id.motion_include_translate -> _navController.navigate(R.id.translateFragment)
                R.id.motion_include_mine -> _navController.navigate(R.id.mineFragment)
                else -> _navController.navigate(R.id.exploreFragment)

            }

            //给控制器添加监听,如当导航目的地是restFragment时候, 将其他三个motionLayout动画过程到0进度位置,可以防止多个motionLayout都到达motionLayout动画100进度位置
            _navController.addOnDestinationChangedListener(object :
                NavController.OnDestinationChangedListener {
                override fun onDestinationChanged(
                    controller: NavController,
                    destination: NavDestination,
                    arguments: Bundle?
                ) {

                    _binding.motionIncludeRest.motionLayoutMainRest.progress = 0f
                    _binding.motionIncludeExplore.motionLayoutMainExplore.progress = 0f
                    _binding.motionIncludeMine.motionLayoutMainMine.progress = 0f
                    _binding.motionIncludeTranslate.motionLayoutMainTranslate.progress = 0f
                    when (destination.id) {
                        R.id.restFragment -> _binding.motionIncludeRest.motionLayoutMainRest.transitionToEnd()
                        R.id.exploreFragment -> _binding.motionIncludeExplore.motionLayoutMainExplore.transitionToEnd()
                        R.id.mineFragment -> _binding.motionIncludeMine.motionLayoutMainMine.transitionToEnd()
                        R.id.translateFragment -> _binding.motionIncludeTranslate.motionLayoutMainTranslate.transitionToEnd()
                    }
                }

            })

        }
    }

}