package com.example.module_main.page.navigate_direction_page

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.module_main.R
import com.example.module_main.data.api.NewsApi
import com.example.module_main.data.bean.CompositionContent
import com.example.module_main.databinding.FragmentCompositionContentBinding
import com.example.module_main.state.CompositionContentViewModel
import com.example.module_main.state.CompositionContentViewModelFactory

class CompositionContentFragment : Fragment() {

    private var _binding: FragmentCompositionContentBinding? = null
    val binding: FragmentCompositionContentBinding get() = _binding!!

    private val viewModel: CompositionContentViewModel by viewModels{ CompositionContentViewModelFactory("343811", NewsApi.newsApiService) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCompositionContentBinding.inflate(inflater, container, false)


        //一定要设置lifecyceOwner否则会出现加载网络后出现数据不出现
        //这是用来监听数据状态，并当改变的时候通知布局更新，也就是通知 xml布局发生改变
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        //viewModel.compositionInfo =
        if(binding.tvWriter.text.toString().isNullOrEmpty()){
            Log.d("DDD_UTL_", "binding.tvWriter.text.toString() 为 empty")
        }else{

        Log.d("DDD_UTL_", binding.tvWriter.text.toString())
        }

        return binding.root
    }

}