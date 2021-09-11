package com.example.module_main.event.fragment

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.DisplayMetrics
import android.view.MenuItem
import android.view.View
import android.view.animation.Interpolator
import com.example.module_main.R

/**
 * [android.view.View.OnClickListener] used to translate the product grid sheet downward on
 * the Y-axis when the navigation icon in the toolbar is pressed.
 */
open class NavigationIconClickListener @JvmOverloads internal constructor(
        private val context: Context, private val sheet: View, private val interpolator: Interpolator? = null,
        private val openIcon: Drawable? = null, private val closeIcon: Drawable? = null) : androidx.appcompat.widget.Toolbar.OnMenuItemClickListener {

    private val animatorSet = AnimatorSet()
    private val height: Int
    private var backdropShown = false

    init {
        val displayMetrics = DisplayMetrics()
        (context as Activity).windowManager.defaultDisplay.getMetrics(displayMetrics)
        height = displayMetrics.heightPixels
    }



    override fun onMenuItemClick(p0: MenuItem?): Boolean {

        if(p0?.itemId == R.id.menuitem_rest_show_backdrop){
            backdropShown = !backdropShown

            // Cancel the existing animations
            animatorSet.removeAllListeners()
            animatorSet.end()
            animatorSet.cancel()

            updateIcon(p0)

            val translateY = height - context.resources.getDimensionPixelSize(R.dimen.nes_rest_reveal_height)

            val animator = ObjectAnimator.ofFloat(sheet, "translationY", (if (backdropShown) translateY else 0).toFloat())
            animator.duration = 500
            if (interpolator != null) {
                animator.interpolator = interpolator
            }
            animatorSet.play(animator)
            animator.start()
        }

        return true
    }

    private fun updateIcon(item: MenuItem?) {
        if (openIcon != null && closeIcon != null) {

            if (backdropShown) {
                item?.icon =  closeIcon
            } else {
                item?.icon =  openIcon
            }
        }
    }


}
