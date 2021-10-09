package com.example.module_main.page.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.module_main.page.tab_rest_page.*

class Vp2RestAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 6

    override fun createFragment(position: Int): Fragment =
        when(position){
            0 -> TabRestFragment()
            1 -> TabHealthyFragment()
            2 -> TabSportsFragment()
            3 -> TabMilitaryFragment()
            4 -> TabScienceFragment()
            else -> TabGameFragment()

        }


}
