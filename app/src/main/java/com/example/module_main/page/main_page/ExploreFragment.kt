package com.example.module_main.page.main_page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.viewpager2.widget.ViewPager2
import com.airbnb.lottie.LottieDrawable
import com.example.module_main.MainActivity
import com.example.module_main.R
import com.example.module_main.base.BaseFragment
import com.example.module_main.base.navhostFragmentsTemplateCodeInExploreFragment
import com.example.module_main.page.adapter.Vp2ExploreAdapter
import com.example.module_main.databinding.FragmentExploreBinding
import com.example.module_main.event.fragment.NavigationIconClickListener
import com.example.module_main.state.MainViewModel
import com.google.android.material.tabs.TabLayoutMediator
/*
* MainAty下的作文页面
* */
class ExploreFragment<noUseVM: ViewModel, DB: FragmentExploreBinding> : BaseFragment<noUseVM,DB>() {
    private var flag = 1
    private val vp2ExploreAdapter: Vp2ExploreAdapter  get() =  Vp2ExploreAdapter(this)
    override fun onStart() {
        super.onStart()
        setHasOptionsMenu(true)
    }

    override fun layoutId(): Int = R.layout.fragment_explore

    override fun initBeforeBinding(savedInstanceState: Bundle?) {}

    override fun initBinding(savedInstanceState: Bundle?) {
        mBinding.navigationOnclickListener = MainViewModel.NavigationOnClickListener((mActivity as MainActivity).findViewById(R.id.drawerLayout))

        navhostFragmentsTemplateCodeInExploreFragment(mBinding, mActivity, flag)
        //整个碎片的进出动画
        //由于需要从tab 碎片中cv控件点击后跳转到作文列表的平移动画，所以需要取消该碎片的进出动画
        /*exitTransition = MaterialElevationScale(false).apply {
            duration = resources.getInteger(R.integer.reply_motion_duration_large).toLong()
        }
        reenterTransition = MaterialElevationScale(true).apply {
            duration = resources.getInteger(R.integer.reply_motion_duration_large).toLong()
        }*/

        //对viewpager2控件进行设置
        mBinding.vp2ExploreContent.let {
            it.adapter = vp2ExploreAdapter
            it.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){

                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                    //滑动的距离等于viewpagerheader lottile动画的进度
                    var numPages = 3
                    mBinding.lottieViewExploreContentViewpagerHeader.progress = (position + positionOffset) / (numPages - 1)

                    super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                }

                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }

                override fun onPageScrollStateChanged(state: Int) {
                    super.onPageScrollStateChanged(state)
                }
            })
        }
    }

    override fun initAfterBinding(savedInstanceState: Bundle?) {
        TabLayoutMediator(mBinding.tabLayReploreContentTab, mBinding.vp2ExploreContent) { tab, position ->

            when (position) {
                0 -> tab.text = "小学"
                1 -> tab.text = "初中"
                else -> tab.text = "高中"
            }

        }.attach()
    }

    override var isHandleFragmentAgainOnCreateView: Boolean = false

    override fun onFragmentDestroy() {}

    override fun onFragmentAttach() {}

}