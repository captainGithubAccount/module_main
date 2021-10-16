package com.example.module_main.page.main_page

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.airbnb.lottie.LottieDrawable
import com.example.module_main.MainActivity
import com.example.module_main.R
import com.example.module_main.base.BaseFragment
import com.example.module_main.base.navhostFragmentsTemplateCodeInMineFragment
import com.example.module_main.databinding.FragmentMineBinding
import com.example.module_main.event.fragment.NavigationIconClickListener
import com.example.module_main.state.MainViewModel
import com.google.android.material.transition.MaterialElevationScale


open class MineFragment<noViewModel: ViewModel,binding: FragmentMineBinding> : BaseFragment<noViewModel, binding>(){
    private var mFlag = 1
    override fun onStart() {
        super.onStart()
        setHasOptionsMenu(true)
    }

    override fun layoutId(): Int = R.layout.fragment_mine

    override fun initBeforeBinding(savedInstanceState: Bundle?) {
        //整个碎片的进出动画
        exitTransition = MaterialElevationScale(false).apply {
            duration = resources.getInteger(R.integer.reply_motion_duration_large).toLong()
        }
        reenterTransition = MaterialElevationScale(true).apply {
            duration = resources.getInteger(R.integer.reply_motion_duration_large).toLong()
        }


    }

    override fun initBinding(savedInstanceState: Bundle?) {
        navhostFragmentsTemplateCodeInMineFragment(mBinding, mActivity, mFlag)
        mBinding.navigationOnclickListener = MainViewModel.NavigationOnClickListener((mActivity as MainActivity).findViewById(R.id.drawerLayout))
    }

    override fun initAfterBinding(savedInstanceState: Bundle?) {

    }

    override fun onFragmentDestroy() {
    }

    override fun onFragmentAttach() {
    }
}