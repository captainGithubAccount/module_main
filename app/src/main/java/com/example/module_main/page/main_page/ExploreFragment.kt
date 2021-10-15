package com.example.module_main.page.main_page

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.airbnb.lottie.LottieDrawable
import com.example.module_main.MainActivity
import com.example.module_main.R
import com.example.module_main.page.adapter.Vp2ExploreAdapter
import com.example.module_main.databinding.FragmentExploreBinding
import com.example.module_main.event.fragment.NavigationIconClickListener
import com.example.module_main.state.MainViewModel
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.transition.MaterialElevationScale

/*
*
* */

class ExploreFragment : Fragment() {


    private val vp2ExploreAdapter: Vp2ExploreAdapter  get() =  Vp2ExploreAdapter(this)



    private var flag = 1
    private var _activity: Activity? = null

    private var _binding: FragmentExploreBinding? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        _activity = activity

    }

    override fun onStart() {
        super.onStart()
        setHasOptionsMenu(true)
    }


    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExploreBinding.inflate(inflater, container, false)
        binding.navigationOnclickListener = MainViewModel.NavigationOnClickListener((_activity as MainActivity).findViewById(R.id.drawerLayout))
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navhostFragmentsTemplateCode()

        //整个碎片的进出动画
        exitTransition = MaterialElevationScale(false).apply {
            duration = resources.getInteger(R.integer.reply_motion_duration_large).toLong()
        }
        reenterTransition = MaterialElevationScale(true).apply {
            duration = resources.getInteger(R.integer.reply_motion_duration_large).toLong()
        }


        //对tabLay文字大小设置


        //对viewpager2控件进行设置
        binding.vp2ExploreContent.let {
            it.adapter = vp2ExploreAdapter
            it.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){

                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                    //滑动的距离等于viewpagerheader lottile动画的进度
                    var numPages = 3
                    binding.lottieViewExploreContentViewpagerHeader.progress = (position + positionOffset) / (numPages - 1)

                    super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                }

                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }

                override fun onPageScrollStateChanged(state: Int) {
                    super.onPageScrollStateChanged(state)
                }
            })
        }


        TabLayoutMediator(binding.tabLayReploreContentTab, binding.vp2ExploreContent) { tab, position ->

            when (position) {
                0 -> tab.text = "小学"
                1 -> tab.text = "初中"
                else -> tab.text = "高中"
            }

        }.attach()


    }






















    //三个共有toolbar的模版监听代码
    private fun navhostFragmentsTemplateCode() {
        //加载toolbar上的菜单
        binding.toolbarFragmentsInNavhost.inflateMenu(R.menu.menu_rest_toobar)


        //菜单item点击监听
        binding.toolbarFragmentsInNavhost.setOnMenuItemClickListener(object :
            NavigationIconClickListener(
                _activity!!,
                binding.nsvFragmentsInNavhostContent,
                AccelerateDecelerateInterpolator(),
                ContextCompat.getDrawable(
                    _activity!!,
                    R.drawable.ic_rest_menu_show_backdrop_end// Menu open icon
                ),
                ContextCompat.getDrawable(
                    _activity!!,
                    R.drawable.ic_rest_menu_show_backdrop_start// Menu close icon
                )
            ) {
            override fun onMenuItemClick(p0: MenuItem?): Boolean {

                when (p0?.itemId) {
                    R.id.menuitem_rest_show_backdrop -> {

                        flag++
                        if (flag % 2 == 0)
                        //Toast.makeText(_activity,"hi",Toast.LENGTH_SHORT).show()
                            binding.includeFragmentsInNavhostBackdropLottie.lottileviewFragmentsInNavhostBackdropLottie.also {
                                it.repeatCount = 10
                                it.repeatMode = LottieDrawable.RESTART
                                it.playAnimation()
                            }
                        else
                            binding.includeFragmentsInNavhostBackdropLottie.lottileviewFragmentsInNavhostBackdropLottie.pauseAnimation()

                        true
                    }

                    else -> false
                }

                return super.onMenuItemClick(p0)

            }
        })
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }




}