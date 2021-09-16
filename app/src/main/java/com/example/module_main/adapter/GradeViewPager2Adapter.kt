package com.example.module_main.adapter

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.module_main.page.TabOneFragment
import com.example.module_main.page.TabThreeFragment
import com.example.module_main.page.TabTwoFragment

class GradeViewPager2Adapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment =
        when(position){
            0 -> TabOneFragment()
            1 -> TabTwoFragment()
            else -> TabThreeFragment()
        }



}