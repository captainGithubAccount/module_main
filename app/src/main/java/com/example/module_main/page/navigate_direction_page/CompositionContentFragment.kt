package com.example.module_main.page.navigate_direction_page

import android.graphics.Color
import android.os.Bundle

import androidx.core.view.doOnPreDraw
import androidx.fragment.app.viewModels
import com.example.module_main.R
import com.example.module_main.base.BaseFragment
import com.example.module_main.data.api.Api
import com.example.module_main.databinding.FragmentCompositionContentBinding
import com.example.module_main.state.CompositionContentViewModel
import com.example.module_main.state.CompositionContentViewModelFactory
import com.example.module_main.utils.themeColor
import com.google.android.material.transition.MaterialContainerTransform
/*
* 从composition列表页面跳转后的作文详情页面
* */
class CompositionContentFragment<VM: CompositionContentViewModel, DB :FragmentCompositionContentBinding> : BaseFragment<VM, DB>() {
    private val viewModel: CompositionContentViewModel by viewModels{ CompositionContentViewModelFactory("343811", Api.API_SERVICE) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = MaterialContainerTransform().apply {
            drawingViewId = R.id.nav_main_host_fragment
            duration = resources.getInteger(R.integer.reply_motion_duration_large).toLong()
            scrimColor = Color.TRANSPARENT
            setAllContainerColors(requireContext().themeColor(R.attr.colorSurface))
        }
    }

    override var isHandleFragmentAgainOnCreateView: Boolean = false

    override fun onFragmentDestroy() {}

    override fun onFragmentAttach() {}

    override fun layoutId(): Int = R.layout.fragment_composition_content

    override fun initBeforeBinding(savedInstanceState: Bundle?) {
        //等待加载列表
        postponeEnterTransition()
        view?.doOnPreDraw { startPostponedEnterTransition() }
    }

    override fun initBinding(savedInstanceState: Bundle?) {
        //一定要设置lifecyceOwner否则会出现加载网络后出现数据不出现
        //这是用来监听数据状态，并当改变的时候通知布局更新，也就是通知 xml布局发生改变
        mBinding.lifecycleOwner = this
        mBinding.viewmodel = viewModel
    }

    override fun initAfterBinding(savedInstanceState: Bundle?) {}

}