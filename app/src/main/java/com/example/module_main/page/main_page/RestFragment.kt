package com.example.module_main.page.main_page

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import com.example.module_main.databinding.FragmentRestBinding
import androidx.core.content.ContextCompat
import com.airbnb.lottie.LottieDrawable
import com.example.module_main.R
import com.example.module_main.event.fragment.NavigationIconClickListener
import com.example.module_main.page.adapter.Vp2RestAdapter
import com.google.android.material.tabs.TabLayoutMediator


class RestFragment : Fragment() {
    private var flag = 1
    private var _activity: Activity? = null

    private val _vp2RvRestAdapter: Vp2RestAdapter by lazy{
        Vp2RestAdapter(this)
    }

    private var _binding: FragmentRestBinding? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        _activity = activity

    }


    override fun onStart() {
        super.onStart()
        Log.d("DDD","----    Rest  Start")
        setHasOptionsMenu(true)
    }


    // This property is only valid between onCreateView and
// onDestroyView.
    private val fragmentRestBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.d("DDD","----    Rest  OnCreateView")

        _binding = FragmentRestBinding.inflate(inflater, container, false)

        _binding?.let {
            it.lifecycleOwner = this
            //it.rvRestContent.adapter = _restRvAdapter

            it.vp2RestContent.adapter = _vp2RvRestAdapter
        }
        val view = fragmentRestBinding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navhostFragmentsTemplateCode()

        TabLayoutMediator(fragmentRestBinding.tabLayRestHealthy, fragmentRestBinding.vp2RestContent) { tab,position ->

            when (position) {
                0 -> tab.text = "娱乐"
                1 -> tab.text = "健康"
                2 -> tab.text = "体育"
                3 -> tab.text = "军事"
                4 -> tab.text = "科技"
                else -> tab.text = "游戏"
            }

        }.attach()

    }






















    //三个共有toolbar的模版监听代码 
    private fun navhostFragmentsTemplateCode() {
        //加载toolbar上的菜单
        fragmentRestBinding.toolbarFragmentsInNavhost.inflateMenu(R.menu.menu_rest_toobar)


        //菜单item点击监听
        fragmentRestBinding.toolbarFragmentsInNavhost.setOnMenuItemClickListener(object :
            NavigationIconClickListener(
                _activity!!,
                fragmentRestBinding.nsvFragmentsInNavhostContent,
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
                            fragmentRestBinding.includeFragmentsInNavhostBackdropLottie.lottileviewFragmentsInNavhostBackdropLottie.also {
                                it.repeatCount = 10
                                it.repeatMode = LottieDrawable.RESTART
                                it.playAnimation()
                            }
                        else
                            fragmentRestBinding.includeFragmentsInNavhostBackdropLottie.lottileviewFragmentsInNavhostBackdropLottie.pauseAnimation()

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
        Log.d("DDD","----    Rest  Destroy")
        _binding = null
    }



    override fun onResume() {
        super.onResume()

        Log.d("DDD","----    Rest  Resume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("DDD","----    Rest  Pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("DDD","----    Rest  Stop")
    }

}