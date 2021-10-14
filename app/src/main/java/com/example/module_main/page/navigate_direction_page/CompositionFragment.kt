package com.example.module_main.page.navigate_direction_page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.module_main.R
import com.example.module_main.data.api.NewsApi
import com.example.module_main.databinding.FragmentCompositionBinding
import com.example.module_main.page.adapter.RvCompositionAdapter
import com.example.module_main.state.CompositionViewModel
import com.example.module_main.state.CompositionViewModelFactory

class CompositionFragment : Fragment() {
    private val viewmodel: CompositionViewModel by viewModels { CompositionViewModelFactory("1", NewsApi.newsApiService) }
    private val adapter get() = RvCompositionAdapter()
    private var _binding: FragmentCompositionBinding? = null
    private val binding: FragmentCompositionBinding get() = _binding!!

    val args: CompositionFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCompositionBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        binding.lifecycleOwner = this
        binding.viewmodel = viewmodel
        binding.rvComposition.adapter = adapter



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data: String = args.url
        binding.rvComposition.adapter = adapter

    }


}