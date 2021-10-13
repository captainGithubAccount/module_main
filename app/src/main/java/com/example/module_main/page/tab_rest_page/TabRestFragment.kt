package com.example.module_main.page.tab_rest_page

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.module_main.data.api.NewsApi
import com.example.module_main.data.bean.Data
import com.example.module_main.databinding.FragmentTapInRestRestBinding
import com.example.module_main.event.fragment.RvTapsAdapterListener
import com.example.module_main.page.adapter.RvTapsAdapter
import com.example.module_main.page.main_page.RestFragmentDirections
import com.example.module_main.state.TapRestViewModel
import com.example.module_main.state.TapRestViewModelFactory

class TabRestFragment : Fragment(), RvTapsAdapterListener {

    private val viewModel: TapRestViewModel by viewModels { TapRestViewModelFactory(NewsApi.newsApiService) }
    private val rvAdapter: RvTapsAdapter by lazy { RvTapsAdapter(this) }

    private var _binding: FragmentTapInRestRestBinding? = null
    private val binding: FragmentTapInRestRestBinding
        get() = _binding!!



    //此方法用于测试使用databingding绑定事件传参跳转的，没有实际作用
    override fun rvItemOnclick(viewRoot: View, news: Data?) {
        if(news != null){
            val actionRestFragmentToNewsDetailFragment: NavDirections =
                RestFragmentDirections.actionRestFragmentToNewsDetailFragment(news)

            this.findNavController().navigate(actionRestFragmentToNewsDetailFragment)
        }

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("DDD", "Rest Tap onCreateView")

        _binding = FragmentTapInRestRestBinding.inflate(inflater)
        // Inflate the layout for this fragment


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



        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("DDD", "Rest Tap Create")
    }


    override fun onStart() {
        super.onStart()

        Log.d("DDD", "Rest Tap Start")
    }

    override fun onResume() {
        super.onResume()

        Log.d("DDD", "Rest Tap Resume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("DDD", "Rest Tap Pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("DDD", "Rest Tap Stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("DDD", "Rest Tap Destroy")
        _binding = null
    }




}