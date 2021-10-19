package com.example.module_main.page.main_page

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.view.Window
import android.view.animation.AccelerateDecelerateInterpolator
import com.example.module_main.databinding.FragmentRestBinding
import androidx.core.content.ContextCompat
import androidx.core.view.doOnPreDraw
import androidx.lifecycle.ViewModel
import com.airbnb.lottie.LottieDrawable
import com.example.module_main.MainActivity
import com.example.module_main.R
import com.example.module_main.base.BaseFragment
import com.example.module_main.base.navhostFragmentsTemplateCodeInRestFragment
import com.example.module_main.event.fragment.NavigationIconClickListener
import com.example.module_main.page.adapter.Vp2RestAdapter
import com.example.module_main.state.MainViewModel
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.transition.MaterialElevationScale
/*
* MainAty下的新闻页面
* */
class RestFragment<noUseVM: ViewModel, DB: FragmentRestBinding> : BaseFragment<noUseVM, DB>() {
    private var flag = 1
    //注意这里不能使用懒加载创建adapter，因为jetpack默认导航会使得活动重建和销毁，这个时候adpter为null，无法重新获取
    private val _vp2RvRestAdapter: Vp2RestAdapter get() = Vp2RestAdapter(this)

    override fun layoutId(): Int = R.layout.fragment_rest

    override fun initBeforeBinding(savedInstanceState: Bundle?) {
        //解决点击返回后没有折叠的动画效果，注意这里一定要在加载完了背景视图和里面嵌套视图后设置，否则会同时出现先加载其他布局和显示动画
        // 尝试运行您的返回转换时，电子邮件列表尚未膨胀并填充到其中RecyclerView。HomeFragment在开始转换之前，我们需要一种方法来等待我们列出我们的列表。
        // 如果postponeEnterTransition被调用，任何要运行的进入转换将被保持，直到调用结束调用startPostponedEnterTransition。这使我们有机会“安排”我们的转换，直到RecyclerView用电子邮件填充并且转换能够找到您配置的映射之后。
        postponeEnterTransition()
        view?.doOnPreDraw { startPostponedEnterTransition() }


        //整个碎片的动画
        //设置进出动画，避免列表跳转到详情页除了该列表其他部分白屏的情况
        exitTransition = MaterialElevationScale(false).apply {
            duration = resources.getInteger(R.integer.reply_motion_duration_large).toLong()
        }

        reenterTransition = MaterialElevationScale(true).apply {
            duration = resources.getInteger(R.integer.reply_motion_duration_large).toLong()
        }
    }

    override fun initBinding(savedInstanceState: Bundle?) {
        navhostFragmentsTemplateCodeInRestFragment(mBinding, mActivity, flag)
        mBinding.let {
            it.lifecycleOwner = this
            //it.rvRestContent.adapter = _restRvAdapter

            it.vp2RestContent.adapter = _vp2RvRestAdapter

            it.navigationOnclickListener = MainViewModel.NavigationOnClickListener((mActivity as MainActivity).findViewById(R.id.drawerLayout))
        }
    }
    override fun initAfterBinding(savedInstanceState: Bundle?) {
        TabLayoutMediator(mBinding.tabLayRestHealthy, mBinding.vp2RestContent) { tab, position ->

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

    override var isHandleFragmentAgainOnCreateView: Boolean = false

    override fun onFragmentDestroy() {}

    override fun onFragmentAttach() {}

}