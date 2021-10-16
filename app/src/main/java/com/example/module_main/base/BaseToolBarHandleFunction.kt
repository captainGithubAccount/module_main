package com.example.module_main.base

import android.app.Activity
import android.view.MenuItem
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.core.content.ContextCompat
import androidx.databinding.ViewDataBinding
import com.airbnb.lottie.LottieDrawable
import com.example.module_main.R
import com.example.module_main.databinding.FragmentExploreBinding
import com.example.module_main.databinding.FragmentMineBinding
import com.example.module_main.databinding.FragmentRestBinding
import com.example.module_main.event.fragment.NavigationIconClickListener

const val FRAGMENT_MINE_BINDING: Int = 4
const val FRAGMENT_EXPLORE_BINDING: Int = 3
const val FRAGMENT_TRANSLATE_BINDING: Int = 2
const val FRAGMENT_REST_BINDING: Int = 1

/*
* ExploreFragment
* */
//三个共有toolbar的模版监听代码
fun navhostFragmentsTemplateCodeInExploreFragment(mBinding: FragmentExploreBinding, mActivity: Activity, judeFlag: Int) {
    var flag = judeFlag
    //加载toolbar上的菜单
    mBinding.toolbarFragmentsInNavhost.inflateMenu(R.menu.menu_rest_toobar)


    //菜单item点击监听
    mBinding.toolbarFragmentsInNavhost.setOnMenuItemClickListener(object :
        NavigationIconClickListener(
            mActivity!!,
            mBinding.nsvFragmentsInNavhostContent,
            AccelerateDecelerateInterpolator(),
            ContextCompat.getDrawable(
                mActivity!!,
                R.drawable.ic_rest_menu_show_backdrop_end// Menu open icon
            ),
            ContextCompat.getDrawable(
                mActivity!!,
                R.drawable.ic_rest_menu_show_backdrop_start// Menu close icon
            )
        ) {
        override fun onMenuItemClick(p0: MenuItem?): Boolean {

            when (p0?.itemId) {
                R.id.menuitem_rest_show_backdrop -> {

                    flag++
                    if (flag % 2 == 0)
                    //Toast.makeText(_activity,"hi",Toast.LENGTH_SHORT).show()
                        mBinding.includeFragmentsInNavhostBackdropLottie.lottileviewFragmentsInNavhostBackdropLottie.also {
                            it.repeatCount = 10
                            it.repeatMode = LottieDrawable.RESTART
                            it.playAnimation()
                        }
                    else
                        mBinding.includeFragmentsInNavhostBackdropLottie.lottileviewFragmentsInNavhostBackdropLottie.pauseAnimation()

                    true
                }

                else -> false
            }

            return super.onMenuItemClick(p0)

        }
    })
}

/*
* RestFragment
* */
//三个共有toolbar的模版监听代码
fun navhostFragmentsTemplateCodeInRestFragment(mBinding: FragmentRestBinding, mActivity: Activity, judeFlag: Int) {
    var flag = judeFlag
    //加载toolbar上的菜单
    mBinding.toolbarFragmentsInNavhost.inflateMenu(R.menu.menu_rest_toobar)


    //菜单item点击监听
    mBinding.toolbarFragmentsInNavhost.setOnMenuItemClickListener(object :
        NavigationIconClickListener(
            mActivity!!,
            mBinding.nsvFragmentsInNavhostContent,
            AccelerateDecelerateInterpolator(),
            ContextCompat.getDrawable(
                mActivity!!,
                R.drawable.ic_rest_menu_show_backdrop_end// Menu open icon
            ),
            ContextCompat.getDrawable(
                mActivity!!,
                R.drawable.ic_rest_menu_show_backdrop_start// Menu close icon
            )
        ) {
        override fun onMenuItemClick(p0: MenuItem?): Boolean {

            when (p0?.itemId) {
                R.id.menuitem_rest_show_backdrop -> {

                    flag++
                    if (flag % 2 == 0)
                    //Toast.makeText(_activity,"hi",Toast.LENGTH_SHORT).show()
                        mBinding.includeFragmentsInNavhostBackdropLottie.lottileviewFragmentsInNavhostBackdropLottie.also {
                            it.repeatCount = 10
                            it.repeatMode = LottieDrawable.RESTART
                            it.playAnimation()
                        }
                    else
                        mBinding.includeFragmentsInNavhostBackdropLottie.lottileviewFragmentsInNavhostBackdropLottie.pauseAnimation()

                    true
                }

                else -> false
            }

            return super.onMenuItemClick(p0)

        }
    })
}


/*
* MineFragment
* */
//三个共有toolbar的模版监听代码
 fun navhostFragmentsTemplateCodeInMineFragment(mBinding: FragmentMineBinding, mActivity: Activity, judeFlag: Int) {
    var flag = judeFlag
    //加载toolbar上的菜单
    mBinding.toolbarFragmentsInNavhost.inflateMenu(R.menu.menu_rest_toobar)
    //菜单item点击监听
    mBinding.toolbarFragmentsInNavhost.setOnMenuItemClickListener(object :
        NavigationIconClickListener(
            mActivity,
            mBinding.nsvFragmentsInNavhostContent,
            AccelerateDecelerateInterpolator(),
            ContextCompat.getDrawable(
                mActivity,
                R.drawable.ic_rest_menu_show_backdrop_end// Menu open icon
            ),
            ContextCompat.getDrawable(
                mActivity,
                R.drawable.ic_rest_menu_show_backdrop_start// Menu close icon
            )
        ) {
        override fun onMenuItemClick(p0: MenuItem?): Boolean {

            when (p0?.itemId) {
                R.id.menuitem_rest_show_backdrop -> {

                    flag++
                    if (flag % 2 == 0)
                    //Toast.makeText(_activity,"hi",Toast.LENGTH_SHORT).show()
                        mBinding.includeFragmentsInNavhostBackdropLottie.lottileviewFragmentsInNavhostBackdropLottie.also {
                            it.repeatCount = 10
                            it.repeatMode = LottieDrawable.RESTART
                            it.playAnimation()
                        }
                    else
                        mBinding.includeFragmentsInNavhostBackdropLottie.lottileviewFragmentsInNavhostBackdropLottie.pauseAnimation()


                }
            }

            return super.onMenuItemClick(p0)

        }
    })
}