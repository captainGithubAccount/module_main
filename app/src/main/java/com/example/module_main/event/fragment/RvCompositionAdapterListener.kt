package com.example.module_main.event.fragment

import com.example.module_main.data.bean.CompositionInfo

interface RvCompositionAdapterListener {
    fun RvItemOnclick()
}
interface RvCompositionAdapterPositionLintener{
    fun setPosition(position: Int)
}