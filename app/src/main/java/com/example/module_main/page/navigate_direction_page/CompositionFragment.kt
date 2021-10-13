package com.example.module_main.page.navigate_direction_page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.module_main.R
import com.example.module_main.databinding.FragmentCompositionBinding

class CompositionFragment : Fragment() {
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


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data: String = args.url
        binding.tvTest.text = data

    }


}