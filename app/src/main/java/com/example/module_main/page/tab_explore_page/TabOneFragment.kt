package com.example.module_main.page.tab_explore_page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.module_main.R
import com.example.module_main.databinding.FragmentTabInExploreOneBinding
import com.example.module_main.event.fragment.TabOneFragmentListener
import com.example.module_main.page.main_page.ExploreFragmentDirections


class TabOneFragment : Fragment(), TabOneFragmentListener {
    private var _binding: FragmentTabInExploreOneBinding? = null
    private val binding: FragmentTabInExploreOneBinding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun classOnclickListener(url: String) {
        val actionExploreFragmentToCompositionFragment: NavDirections =
            ExploreFragmentDirections.actionExploreFragmentToCompositionFragment(url)
        findNavController().navigate(actionExploreFragmentToCompositionFragment)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTabInExploreOneBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = this
        binding.tabOneFragmentListener = this
        // Inflate the layout for this fragment
        return binding.root
    }


}