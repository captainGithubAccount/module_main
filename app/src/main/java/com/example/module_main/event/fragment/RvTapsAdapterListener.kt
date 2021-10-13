package com.example.module_main.event.fragment

import android.view.View
import com.example.module_main.data.bean.Data

interface RvTapsAdapterListener {
    fun rvItemOnclick(viewRoot: View, news: Data?)
}