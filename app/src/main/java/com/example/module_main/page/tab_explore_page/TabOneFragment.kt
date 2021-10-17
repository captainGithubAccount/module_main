package com.example.module_main.page.tab_explore_page

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.module_main.R
import com.example.module_main.base.BaseFragment
import com.example.module_main.databinding.FragmentTabInExploreOneBinding
import com.example.module_main.event.fragment.CompositionGradeListener
import com.example.module_main.page.main_page.ExploreFragmentDirections


class TabOneFragment<noViewModel: ViewModel,DB: FragmentTabInExploreOneBinding> : BaseFragment<noViewModel,DB>(), CompositionGradeListener {
    //点击跳转到作文列表页面
    override fun classOnclickListener(urlParameter: String, baseUrl: String) {
        val actionExploreFragmentToCompositionFragment: NavDirections =
            ExploreFragmentDirections.actionExploreFragmentToCompositionFragment(urlParameter, baseUrl)
        findNavController().navigate(actionExploreFragmentToCompositionFragment)

    }

    override var isHandleFragmentAgainOnCreateView: Boolean = false

    override fun onFragmentDestroy() {}

    override fun onFragmentAttach() {}

    override fun layoutId(): Int = R.layout.fragment_tab_in_explore_one

    override fun initBeforeBinding(savedInstanceState: Bundle?) {}

    override fun initBinding(savedInstanceState: Bundle?) {
        mBinding.lifecycleOwner = this
        mBinding.listener = this
    }

    override fun initAfterBinding(savedInstanceState: Bundle?) {}
}