package com.example.module_main.page.navigate_direction_page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.module_main.data.api.NewsApi
import com.example.module_main.databinding.FragmentCompositionListBinding
import com.example.module_main.event.fragment.RvCompositionAdapterListener
import com.example.module_main.event.fragment.RvCompositionAdapterPositionLintener
import com.example.module_main.page.adapter.RvCompositionAdapter
import com.example.module_main.state.CompositionListViewModel
import com.example.module_main.state.CompositionListViewModelFactory

class CompositionListFragment : Fragment(), RvCompositionAdapterListener{
    private val viewmodel: CompositionListViewModel by viewModels { CompositionListViewModelFactory("1", NewsApi.newsApiService) }
    private val adapter get() = RvCompositionAdapter(this)
    private var _binding: FragmentCompositionListBinding? = null
    private val binding: FragmentCompositionListBinding get() = _binding!!

    val args: CompositionListFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCompositionListBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        binding.lifecycleOwner = this
        binding.viewmodel = viewmodel
        binding.rvComposition.adapter = adapter
        //(binding.rvComposition.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data: String = args.url
        binding.rvComposition.adapter = adapter

    }

    override fun RvItemOnclick() {

        val actionCompositionFragmentToCompositionContentFragment =
            CompositionListFragmentDirections.actionCompositionFragmentToCompositionContentFragment(viewmodel.compositionResult.value!!)
        findNavController().navigate(actionCompositionFragmentToCompositionContentFragment)
    }


    //通过接口回掉拿到对应的item下标
    /*override fun setPosition(position: Int) {
        adapter.selectIndex = position
        RvItemOnclick()
    }*/


}