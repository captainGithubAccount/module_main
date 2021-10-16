package com.example.module_main.page.navigate_direction_page

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.module_main.R
import com.example.module_main.base.BaseFragment
import com.example.module_main.data.bean.Data
import com.example.module_main.databinding.FragmentNewsDetailBinding
import com.example.module_main.event.fragment.NewsDetailFragmentListener
import com.example.module_main.utils.themeColor
import com.google.android.material.transition.MaterialContainerTransform
/*
* 从新闻列表页面跳转后的新闻详情页面
* */
class NewsDetailFragment<noUseVM: ViewModel, DB: FragmentNewsDetailBinding> : BaseFragment<noUseVM, DB>(), NewsDetailFragmentListener {

    val args: NewsDetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = MaterialContainerTransform().apply {
            drawingViewId = R.id.nav_main_host_fragment
            duration = resources.getInteger(R.integer.reply_motion_duration_large).toLong()
            scrimColor = Color.TRANSPARENT
            setAllContainerColors(requireContext().themeColor(R.attr.colorSurface))
        }
    }

    //新闻详情界面的返回箭头监听
    override fun icBackOnClickListener() {
        findNavController().navigateUp()
    }

    override var isHandleFragmentAgainOnCreateView: Boolean = false

    override fun onFragmentDestroy() {}

    override fun onFragmentAttach() {}

    override fun layoutId(): Int = R.layout.fragment_news_detail

    override fun initBeforeBinding(savedInstanceState: Bundle?) {}

    override fun initBinding(savedInstanceState: Bundle?) {
        mBinding.lifecycleOwner = this
        //val data: Data = NewsDetailFragmentArgs.fromBundle(requireArguments()).news
        //binding.data = data
        val data: Data = args.news
        mBinding.data = data

        mBinding.imgBackListener = this
    }

    override fun initAfterBinding(savedInstanceState: Bundle?) {}


}