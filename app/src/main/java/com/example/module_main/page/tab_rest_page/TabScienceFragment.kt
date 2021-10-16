package com.example.module_main.page.tab_rest_page

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.module_main.R
import com.example.module_main.base.BaseFragment
import com.example.module_main.data.api.Api
import com.example.module_main.data.bean.Data
import com.example.module_main.data.bean.URL_MILITARY
import com.example.module_main.data.bean.URL_SCIENCE
import com.example.module_main.databinding.FragmentTabInRestBinding
import com.example.module_main.event.fragment.RvTapsAdapterListener
import com.example.module_main.page.adapter.RvTapsAdapter
import com.example.module_main.page.main_page.RestFragmentDirections
import com.example.module_main.state.TapRestViewModel
import com.example.module_main.state.TapRestViewModelFactory

/*
* RestFrg下的科学列表页面
* */
class TabScienceFragment<VM: TapRestViewModel, DB: FragmentTabInRestBinding> : BaseFragment<VM, DB>(), RvTapsAdapterListener {
    private val viewModel: TapRestViewModel by viewModels { TapRestViewModelFactory(URL_SCIENCE,Api.API_SERVICE) }
    private val rvAdapter: RvTapsAdapter by lazy { RvTapsAdapter(this) }
    //listitem 点击跳转到新闻详情界面，跳转参数为列表item的数据
    override fun rvItemOnclick(viewRoot: View, news: Data?) {
        if(news != null){
            val newsCardDetailTransitionName = getString(R.string.news_card_detail_transition_name)
            val extras = FragmentNavigatorExtras(viewRoot to  newsCardDetailTransitionName)
            val actionRestFragmentToNewsDetailFragment: NavDirections =
                RestFragmentDirections.actionRestFragmentToNewsDetailFragment(news)
            this.findNavController().navigate(actionRestFragmentToNewsDetailFragment, extras)
        }
    }
    override var isHandleFragmentAgainOnCreateView: Boolean = true

    override fun layoutId(): Int = R.layout.fragment_tab_in_rest

    override fun initBeforeBinding(savedInstanceState: Bundle?) {}

    override fun initBinding(savedInstanceState: Bundle?) {
        mBinding.lifecycleOwner = this
        mBinding.viewModel = viewModel
        mBinding.rvTapRestOverview.adapter = rvAdapter
    }

    override fun initAfterBinding(savedInstanceState: Bundle?) {}

    override fun onFragmentDestroy() {}

    override fun onFragmentAttach() {}

}