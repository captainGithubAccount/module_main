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
import com.example.module_main.data.bean.*
import com.example.module_main.databinding.FragmentTabInRestBinding
import com.example.module_main.event.fragment.RvTapsAdapterListener
import com.example.module_main.page.adapter.RvTapsAdapter
import com.example.module_main.page.main_page.RestFragmentDirections
import com.example.module_main.state.TapRestViewModel
import com.example.module_main.state.TapRestViewModelFactory
import kotlinx.coroutines.runBlocking

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
        mBinding.srlTabAgainSendRequest.let {
            it.setOnRefreshListener {
                //由于接口每次返回的数据都是一样的无法起到下拉刷新的效果，所以需要更换访问的url
                val urlList: ArrayList<String> = arrayListOf(URL_GAME, URL_MILITARY, URL_REST, URL_SPORTS, URL_SCIENCE, URL_HEALTHY)
                runBlocking {
                    //阻塞主线程防止网络还未加载完，下拉刷新的按钮已经失效
                    viewModel.getNews(urlList.random())
                }
                it.isRefreshing = false

            }
        }
    }

    override fun initAfterBinding(savedInstanceState: Bundle?) {}

    override fun onFragmentDestroy() {}

    override fun onFragmentAttach() {}

}