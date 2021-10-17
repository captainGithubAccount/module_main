package com.example.module_main.page.tab_explore_page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.module_main.R
import com.example.module_main.base.BaseFragment
import com.example.module_main.databinding.FragmentTabInExploreOneBinding
import com.example.module_main.databinding.FragmentTabInExploreThreeBinding
import com.example.module_main.event.fragment.CompositionGradeListener
import com.example.module_main.page.main_page.ExploreFragmentDirections


class TabThreeFragment<noViewModel: ViewModel,DB: FragmentTabInExploreThreeBinding> : BaseFragment<noViewModel, DB>(),
    CompositionGradeListener {
    //点击跳转到作文列表页面
    override fun classOnclickListener(urlParameter: String, baseUrl: String) {
        val actionExploreFragmentToCompositionFragment: NavDirections =
            ExploreFragmentDirections.actionExploreFragmentToCompositionFragment(urlParameter, baseUrl)
        findNavController().navigate(actionExploreFragmentToCompositionFragment)

    }

    override var isHandleFragmentAgainOnCreateView: Boolean = false

    override fun onFragmentDestroy() {}

    override fun onFragmentAttach() {}

    override fun layoutId(): Int = R.layout.fragment_tab_in_explore_three

    override fun initBeforeBinding(savedInstanceState: Bundle?) {}

    override fun initBinding(savedInstanceState: Bundle?) {
        mBinding.lifecycleOwner = this
        mBinding.listener = this
    }

    override fun initAfterBinding(savedInstanceState: Bundle?) {}
}