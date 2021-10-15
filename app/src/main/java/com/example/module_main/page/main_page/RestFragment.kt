package com.example.module_main.page.main_page

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import com.example.module_main.databinding.FragmentRestBinding
import androidx.core.content.ContextCompat
import androidx.core.view.doOnPreDraw
import com.airbnb.lottie.LottieDrawable
import com.example.module_main.MainActivity
import com.example.module_main.R
import com.example.module_main.event.fragment.NavigationIconClickListener
import com.example.module_main.page.adapter.Vp2RestAdapter
import com.example.module_main.state.MainViewModel
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.transition.MaterialElevationScale


class RestFragment : Fragment() {
    private var flag = 1
    private var _activity: Activity? = null


    //注意这里不能使用懒加载创建adapter，因为jetpack默认导航会使得活动重建和销毁，这个时候adpter为null，无法重新获取
    private val _vp2RvRestAdapter: Vp2RestAdapter get() = Vp2RestAdapter(this)

    private var _binding: FragmentRestBinding? = null
    private val binding get() = _binding!!
    override fun onAttach(context: Context) {
        super.onAttach(context)
        _activity = activity

        //(_activity as MainActivity).findViewById<DrawerLayout>(R.id.drawerLayout)

    }


    override fun onStart() {
        super.onStart()
        Log.d("DDD","----    Rest  Start")
        setHasOptionsMenu(true)
    }


    // This property is only valid between onCreateView and
// onDestroyView.
    private val fragmentRestBinding get() = binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.d("DDD","----    Rest  OnCreateView")

        _binding = FragmentRestBinding.inflate(inflater, container, false)



        binding?.let {
            it.lifecycleOwner = this
            //it.rvRestContent.adapter = _restRvAdapter

            it.vp2RestContent.adapter = _vp2RvRestAdapter

            it.navigationOnclickListener = MainViewModel.NavigationOnClickListener((_activity as MainActivity).findViewById(R.id.drawerLayout))
        }
        val view = fragmentRestBinding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //解决点击返回后没有折叠的动画效果，注意这里一定要在加载完了背景视图和里面嵌套视图后设置，否则会同时出现先加载其他布局和显示动画
        // 尝试运行您的返回转换时，电子邮件列表尚未膨胀并填充到其中RecyclerView。HomeFragment在开始转换之前，我们需要一种方法来等待我们列出我们的列表。
        // 如果postponeEnterTransition被调用，任何要运行的进入转换将被保持，直到调用结束调用startPostponedEnterTransition。这使我们有机会“安排”我们的转换，直到RecyclerView用电子邮件填充并且转换能够找到您配置的映射之后。
        postponeEnterTransition()
        view.doOnPreDraw { startPostponedEnterTransition() }

        //整个碎片的动画
        //设置进出动画，避免列表跳转到详情页除了该列表其他部分白屏的情况
        exitTransition = MaterialElevationScale(false).apply {
            duration = resources.getInteger(R.integer.reply_motion_duration_large).toLong()
        }

        reenterTransition = MaterialElevationScale(true).apply {
            duration = resources.getInteger(R.integer.reply_motion_duration_large).toLong()
        }




        navhostFragmentsTemplateCode()

        TabLayoutMediator(fragmentRestBinding.tabLayRestHealthy, fragmentRestBinding.vp2RestContent) { tab,position ->

            when (position) {
                0 -> tab.text = "娱乐"
                1 -> tab.text = "健康"
                2 -> tab.text = "体育"
                3 -> tab.text = "军事"
                4 -> tab.text = "科技"
                else -> tab.text = "游戏"
            }

        }.attach()



    }






















    //三个共有toolbar的模版监听代码 
    private fun navhostFragmentsTemplateCode() {
        //加载toolbar上的菜单
        fragmentRestBinding.toolbarFragmentsInNavhost.inflateMenu(R.menu.menu_rest_toobar)


        //菜单item点击监听
        fragmentRestBinding.toolbarFragmentsInNavhost.setOnMenuItemClickListener(object :
            NavigationIconClickListener(
                _activity!!,
                fragmentRestBinding.nsvFragmentsInNavhostContent,
                AccelerateDecelerateInterpolator(),
                ContextCompat.getDrawable(
                    _activity!!,
                    R.drawable.ic_rest_menu_show_backdrop_end// Menu open icon
                ),
                ContextCompat.getDrawable(
                    _activity!!,
                    R.drawable.ic_rest_menu_show_backdrop_start// Menu close icon
                )
            ) {
            override fun onMenuItemClick(p0: MenuItem?): Boolean {

                when (p0?.itemId) {
                    R.id.menuitem_rest_show_backdrop -> {

                        flag++
                        if (flag % 2 == 0)
                        //Toast.makeText(_activity,"hi",Toast.LENGTH_SHORT).show()
                            fragmentRestBinding.includeFragmentsInNavhostBackdropLottie.lottileviewFragmentsInNavhostBackdropLottie.also {
                                it.repeatCount = 10
                                it.repeatMode = LottieDrawable.RESTART
                                it.playAnimation()
                            }
                        else
                            fragmentRestBinding.includeFragmentsInNavhostBackdropLottie.lottileviewFragmentsInNavhostBackdropLottie.pauseAnimation()

                        true
                    }

                    else -> false
                }

                return super.onMenuItemClick(p0)

            }
        })
    }



    override fun onDestroy() {
        super.onDestroy()
        Log.d("DDD","----    Rest  Destroy")
        _binding = null
    }



    override fun onResume() {
        super.onResume()

        Log.d("DDD","----    Rest  Resume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("DDD","----    Rest  Pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("DDD","----    Rest  Stop")
    }



}