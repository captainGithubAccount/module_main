package com.example.module_main.page.navigate_direction_page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.module_main.R
import com.example.module_main.data.api.NewsApi
import com.example.module_main.databinding.FragmentCompositionListBinding
import com.example.module_main.event.fragment.RvCompositionAdapterListener
import com.example.module_main.page.adapter.RvCompositionAdapter
import com.example.module_main.state.CompositionListViewModel
import com.example.module_main.state.CompositionListViewModelFactory
import com.google.android.material.transition.MaterialElevationScale

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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //进入方法首行设置
        //解决点击返回后没有折叠的动画效果，注意这里一定要在加载完了背景视图和里面嵌套视图后设置，否则会同时出现先加载其他布局和显示动画
        // 尝试运行您的返回转换时，电子邮件列表尚未膨胀并填充到其中RecyclerView。HomeFragment在开始转换之前，我们需要一种方法来等待我们列出我们的列表。
        // 如果postponeEnterTransition被调用，任何要运行的进入转换将被保持，直到调用结束调用startPostponedEnterTransition。这使我们有机会“安排”我们的转换，直到RecyclerView用电子邮件填充并且转换能够找到您配置的映射之后。
        postponeEnterTransition()
        view.doOnPreDraw { startPostponedEnterTransition() }


        binding.lifecycleOwner = this
        binding.viewmodel = viewmodel
        binding.rvComposition.adapter = adapter
        //(binding.rvComposition.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
        val data: String = args.url
        binding.rvComposition.adapter = adapter

    }


    override fun RvItemOnclick(cardView: View) {

        exitTransition = MaterialElevationScale(false).apply {
            duration = resources.getInteger(R.integer.reply_motion_duration_large).toLong()
        }
        reenterTransition = MaterialElevationScale(true).apply {
            duration = resources.getInteger(R.integer.reply_motion_duration_large).toLong()
        }


        //容器转换动画
        val compositionCardDetailTransitionName = getString(R.string.position_detail_transition_name)
        val extras = FragmentNavigatorExtras(cardView to compositionCardDetailTransitionName)

        val actionCompositionFragmentToCompositionContentFragment =
            CompositionListFragmentDirections.actionCompositionFragmentToCompositionContentFragment(viewmodel.compositionResult.value!!)
        findNavController().navigate(actionCompositionFragmentToCompositionContentFragment, extras)
    }


    //通过接口回掉拿到对应的item下标
    /*override fun setPosition(position: Int) {
        adapter.selectIndex = position
        RvItemOnclick()
    }*/


}