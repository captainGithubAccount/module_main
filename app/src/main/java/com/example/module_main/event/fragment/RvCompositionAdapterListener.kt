package com.example.module_main.event.fragment

import android.view.View
import androidx.cardview.widget.CardView
import com.example.module_main.data.bean.CompositionInfo

interface RvCompositionAdapterListener {
    fun RvItemOnclick(cardView: View)
}
interface RvCompositionAdapterPositionLintener{
    fun setPosition(position: Int)
}