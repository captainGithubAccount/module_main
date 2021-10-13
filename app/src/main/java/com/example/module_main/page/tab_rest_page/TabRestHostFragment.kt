package com.example.module_main.page.tab_rest_page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.module_main.databinding.FragmentTabHostRestBinding
import com.example.module_main.databinding.FragmentTabHostRestBindingImpl
import com.example.module_main.databinding.FragmentTapInRestRestBinding

//此方法是用来测试fragment间通过navgation传参的，实际没有作用
class TabRestHostFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentTabHostRestBinding.inflate(inflater).root
    }
}