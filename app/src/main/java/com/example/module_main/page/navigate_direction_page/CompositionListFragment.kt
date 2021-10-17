package com.example.module_main.page.navigate_direction_page

import android.os.Bundle
import android.view.View
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.module_main.R
import com.example.module_main.base.BaseFragment
import com.example.module_main.data.api.Api
import com.example.module_main.data.bean.BASE_URL_INFO_COMPOSITION_GRADE
import com.example.module_main.data.bean.BASE_URL_INFO_COMPOSITION_THEME
import com.example.module_main.databinding.FragmentCompositionListBinding
import com.example.module_main.event.fragment.CompositionListListener
import com.example.module_main.event.fragment.RvCompositionAdapterListener
import com.example.module_main.page.adapter.RvCompositionAdapter
import com.example.module_main.state.CompositionListViewModel
import com.example.module_main.state.CompositionListViewModelFactory
import com.google.android.material.transition.MaterialElevationScale
/*
* ExploreFrg下的作文列表展示页面
* */
class CompositionListFragment<VM:CompositionListViewModel, DB: FragmentCompositionListBinding> : BaseFragment<VM, DB>(), RvCompositionAdapterListener, CompositionListListener{


    private val viewmodel: CompositionListViewModel by viewModels { CompositionListViewModelFactory(args.urlGradeParameter, args.urlBase, Api.API_SERVICE) }
    private val adapter get() = RvCompositionAdapter(this)
    val args: CompositionListFragmentArgs by navArgs()

    override fun RvItemOnclick(cardView: View, pos: Int) {
        //整个碎片的进出动画
        exitTransition = MaterialElevationScale(false).apply {
            duration = resources.getInteger(R.integer.reply_motion_duration_large).toLong()
        }
        reenterTransition = MaterialElevationScale(true).apply {
            duration = resources.getInteger(R.integer.reply_motion_duration_large).toLong()
        }
        //容器转换动画
        val compositionCardDetailTransitionName = getString(R.string.position_detail_transition_name)
        val extras = FragmentNavigatorExtras(cardView to compositionCardDetailTransitionName)

//        val actionCompositionFragmentToCompositionContentFragment =
//            CompositionListFragmentDirections.actionCompositionFragmentToCompositionContentFragment(viewmodel.compositionResult.value!!)
        val actionCompositionFragmentToCompositionContentFragment =
            CompositionListFragmentDirections.actionCompositionFragmentToCompositionContentFragment(viewmodel.compositionInfo.value?.get(pos)!!)
        findNavController().navigate(actionCompositionFragmentToCompositionContentFragment, extras)
    }

    override var isHandleFragmentAgainOnCreateView: Boolean = true

    override fun onFragmentDestroy() {}

    override fun onFragmentAttach() {}

    override fun layoutId(): Int = R.layout.fragment_composition_list

    override fun initBeforeBinding(savedInstanceState: Bundle?) {
        //进入方法首行设置
        //解决点击返回后没有折叠的动画效果，注意这里一定要在加载完了背景视图和里面嵌套视图后设置，否则会同时出现先加载其他布局和显示动画
        // 尝试运行您的返回转换时，电子邮件列表尚未膨胀并填充到其中RecyclerView。HomeFragment在开始转换之前，我们需要一种方法来等待我们列出我们的列表。
        // 如果postponeEnterTransition被调用，任何要运行的进入转换将被保持，直到调用结束调用startPostponedEnterTransition。这使我们有机会“安排”我们的转换，直到RecyclerView用电子邮件填充并且转换能够找到您配置的映射之后。
        postponeEnterTransition()
        view?.doOnPreDraw { startPostponedEnterTransition() }
    }

    override fun initBinding(savedInstanceState: Bundle?) {
        mBinding.lifecycleOwner = this
        mBinding.viewmodel = viewmodel
        mBinding.rvComposition.adapter = adapter
        //(binding.rvComposition.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
        val data: String = args.urlGradeParameter
        mBinding.rvComposition.adapter = adapter
        mBinding.listener = this
        initTitle()
    }

    private fun initTitle() {
        if(args.urlBase == BASE_URL_INFO_COMPOSITION_GRADE){
            when(args.urlGradeParameter){
                "11" -> viewmodel._grade.value = "一年级"
                "12" -> viewmodel._grade.value = "二年级"
                "13" -> viewmodel._grade.value = "三年级"
                "14" -> viewmodel._grade.value = "四年级"
                "15" -> viewmodel._grade.value = "五年级"
                "16" -> viewmodel._grade.value = "六年级"
                "17" -> viewmodel._grade.value = "小升初"

                "21" -> viewmodel._grade.value = "初一"
                "22" -> viewmodel._grade.value = "初二"
                "23" -> viewmodel._grade.value = "初三"
                "24" -> viewmodel._grade.value = "中考"

                "31" -> viewmodel._grade.value = "高一"
                "32" -> viewmodel._grade.value = "高二"
                "33" -> viewmodel._grade.value = "高三"
                "34" -> viewmodel._grade.value = "高考"
            }

        }else if(args.urlBase == BASE_URL_INFO_COMPOSITION_THEME){
            when(args.urlGradeParameter){
                "34" -> viewmodel._grade.value = "看图"
                "31" -> viewmodel._grade.value = "游记"
                "12" -> viewmodel._grade.value = "叙事"
                "40" -> viewmodel._grade.value = "其他"
                "14" -> viewmodel._grade.value = "状物"
                "29" -> viewmodel._grade.value = "诗歌"
                "11" -> viewmodel._grade.value = "写人"

                "13" -> viewmodel._grade.value = "写景"
                "25" -> viewmodel._grade.value = "童话"
                "26" -> viewmodel._grade.value = "散文"
                "15" -> viewmodel._grade.value = "议论文"

                "21" -> viewmodel._grade.value = "读后感"
                "18" -> viewmodel._grade.value = "日记"
                "28" -> viewmodel._grade.value = "寓言"
                "16" -> viewmodel._grade.value = "说明文"

                "32" -> viewmodel._grade.value = "读书笔记"
                "36" -> viewmodel._grade.value = "话题"
                "35" -> viewmodel._grade.value = "想象"
                "22" -> viewmodel._grade.value = "演讲稿"
                "50" -> viewmodel._grade.value = "应用文"
                "17" -> viewmodel._grade.value = "书信"
                "4" -> viewmodel._grade.value = "小说"


            }
        }



    }

    override fun initAfterBinding(savedInstanceState: Bundle?) {}
    //通过接口回掉拿到对应的item下标
    /*override fun setPosition(position: Int) {
        adapter.selectIndex = position
        RvItemOnclick()
    }*/
    override fun imgBackOnClickListener() {
        findNavController().navigateUp()
    }
}
