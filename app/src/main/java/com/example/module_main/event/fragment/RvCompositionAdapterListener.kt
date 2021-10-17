package com.example.module_main.event.fragment

import android.view.View

interface RvCompositionAdapterListener {
    fun RvItemOnclick(cardView: View, pos: Int)
}
interface RvCompositionAdapterPositionLintener{
    fun setPosition(position: Int)
}