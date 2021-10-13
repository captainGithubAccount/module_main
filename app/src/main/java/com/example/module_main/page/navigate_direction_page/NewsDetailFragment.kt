package com.example.module_main.page.navigate_direction_page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.module_main.data.bean.Data
import com.example.module_main.databinding.FragmentNewsDetailBinding

class NewsDetailFragment : Fragment() {

    val args: NewsDetailFragmentArgs by navArgs()

    private var _binding:FragmentNewsDetailBinding? = null

    private val binding: FragmentNewsDetailBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewsDetailBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = this

        //val data: Data = NewsDetailFragmentArgs.fromBundle(requireArguments()).news
        //binding.data = data

        val data: Data = args.news
        binding.data = data

        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }



}