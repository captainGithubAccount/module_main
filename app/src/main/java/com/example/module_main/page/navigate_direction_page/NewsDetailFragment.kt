package com.example.module_main.page.navigate_direction_page

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.module_main.R
import com.example.module_main.data.bean.Data
import com.example.module_main.databinding.FragmentNewsDetailBinding
import com.example.module_main.event.fragment.NewsDetailFragmentListener
import com.example.module_main.utils.themeColor
import com.google.android.material.transition.MaterialContainerTransform

class NewsDetailFragment : Fragment(), NewsDetailFragmentListener {

    val args: NewsDetailFragmentArgs by navArgs()

    private var _binding:FragmentNewsDetailBinding? = null

    private val binding: FragmentNewsDetailBinding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedElementEnterTransition = MaterialContainerTransform().apply {
            drawingViewId = R.id.nav_main_host_fragment
            duration = resources.getInteger(R.integer.reply_motion_duration_large).toLong()
            scrimColor = Color.TRANSPARENT
            setAllContainerColors(requireContext().themeColor(R.attr.colorSurface))
        }
    }

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

        binding.imgBackListener = this

        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    //新闻详情界面的返回箭头监听
    override fun icBackOnClickListener() {
        findNavController().navigateUp()
    }


}