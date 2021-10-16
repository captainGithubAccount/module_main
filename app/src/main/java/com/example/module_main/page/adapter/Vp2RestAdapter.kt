package com.example.module_main.page.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.module_main.databinding.FragmentTabInRestBinding
import com.example.module_main.page.tab_rest_page.*
import com.example.module_main.state.TapRestViewModel

class Vp2RestAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 6

    override fun createFragment(position: Int): Fragment =
        when(position){
            0 -> TabRestFragment<TapRestViewModel,FragmentTabInRestBinding>()
            1 -> TabHealthyFragment<TapRestViewModel,FragmentTabInRestBinding>()
            2 -> TabSportsFragment<TapRestViewModel,FragmentTabInRestBinding>()
            3 -> TabMilitaryFragment<TapRestViewModel,FragmentTabInRestBinding>()
            4 -> TabScienceFragment<TapRestViewModel,FragmentTabInRestBinding>()
            else -> TabGameFragment<TapRestViewModel,FragmentTabInRestBinding>()

        }


}
