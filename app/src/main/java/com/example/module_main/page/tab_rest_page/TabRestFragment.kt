package com.example.module_main.page.tab_rest_page

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.module_main.data.api.NewsApi
import com.example.module_main.data.api.NewsApiService
import com.example.module_main.data.bean.Data
import com.example.module_main.data.bean.URL_REST
import com.example.module_main.databinding.FragmentTapInRestRestBinding
import com.example.module_main.page.adapter.RvTapRestAdapter
import com.example.module_main.state.TapRestViewModel
import com.example.module_main.state.TapRestViewModelFactory
import java.net.URL

class TabRestFragment : Fragment() {

    private val viewModel: TapRestViewModel by viewModels { TapRestViewModelFactory(NewsApi.newsApiService) }
    private val rvAdapter: RvTapRestAdapter by lazy { RvTapRestAdapter() }

    private var _binding: FragmentTapInRestRestBinding? = null
    private val binding: FragmentTapInRestRestBinding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("DDD", "Rest Tap Create")
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