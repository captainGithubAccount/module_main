package com.example.module_main.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

/*
* 此类没有作用,只是我懒,加上这个类在其他地方可能用得着,我也就懒得换了...
* */
open class DrawerContent @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : MotionLayout(context, attrs, defStyleAttr), DrawerLayout.DrawerListener {
    override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
        progress = slideOffset
    }

    override fun onDrawerOpened(drawerView: View) {

    }

    override fun onDrawerClosed(drawerView: View) {

    }

    override fun onDrawerStateChanged(newState: Int) {

    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        (parent as? DrawerLayout)?.addDrawerListener(this)
    }

}