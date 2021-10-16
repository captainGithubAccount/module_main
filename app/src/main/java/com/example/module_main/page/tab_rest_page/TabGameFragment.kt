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
import com.example.module_main.data.api.Api
import com.example.module_main.data.bean.Data
import com.example.module_main.data.bean.URL_GAME
import com.example.module_main.databinding.FragmentTabInRestBinding
import com.example.module_main.event.fragment.RvTapsAdapterListener
import com.example.module_main.page.adapter.RvTapsAdapter
import com.example.module_main.page.main_page.RestFragmentDirections
import com.example.module_main.state.TapRestViewModel
import com.example.module_main.state.TapRestViewModelFactory


class TabGameFragment : Fragment(), RvTapsAdapterListener {

    private val viewModel: TapRestViewModel by viewModels { TapRestViewModelFactory(URL_GAME,Api.API_SERVICE) }
    private val rvAdapter: RvTapsAdapter by lazy { RvTapsAdapter(this) }
    private var _binding: FragmentTabInRestBinding? = null
    private val binding: FragmentTabInRestBinding
        get() = _binding!!
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
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //注意要添加到跟布局的fragment，这里是Restfragment，而不是嵌套fragment
        /*postponeEnterTransition()
        view.doOnPreDraw { startPostponedEnterTransition() }*/
        binding.lifecycleOwner = this
        //viewmodel
        binding.viewModel = viewModel
//        binding.btnTest.setOnClickListener{
//            viewModel.getNews(URL_REST)
//        }
        binding.rvTapRestOverview.adapter = rvAdapter
        /*val list = ArrayList<Data>()
        list.add(Data(
            "name",
            "category",
            "data",
            "content",
            "https://pics5.baidu.com/feed/d53f8794a4c27d1e01cf78c8b3ed4c69dcc43895.jpeg?token=66f090ff0ddccfed80f7093ec6f0d7b1&s=FD81EC1B43A3E4E406ECCDDF030040A3",
            "https://pics5.baidu.com/feed/d53f8794a4c27d1e01cf78c8b3ed4c69dcc43895.jpeg?token=66f090ff0ddccfed80f7093ec6f0d7b1&s=FD81EC1B43A3E4E406ECCDDF030040A3",
            "https://pics5.baidu.com/feed/d53f8794a4c27d1e01cf78c8b3ed4c69dcc43895.jpeg?token=66f090ff0ddccfed80f7093ec6f0d7b1&s=FD81EC1B43A3E4E406ECCDDF030040A3",
            "title",
            "key",
            "ddd"
        ))
        rvAdapter.setData(list)*/
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("DDD", "Rest Tap onCreateView")

        _binding = FragmentTabInRestBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }






}