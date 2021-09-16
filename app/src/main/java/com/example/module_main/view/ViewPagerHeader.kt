package com.example.module_main.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2

class ViewPagerHeader @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : MotionLayout(context, attrs, defStyleAttr), ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        progress = position
    }

}