package com.example.module_main.page.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.module_main.data.bean.Data
import com.example.module_main.databinding.FragmentTapInRestRestBinding
import com.example.module_main.databinding.ListitemTapsViewholder1Binding

const val TYPE_VIEWHOLDER_ONE_PICTURE: Int = 1
const val TYPE_VIEWHOLDER_TWO_PICTURE: Int = 2
const val TYPE_VIEWHOLDER_THREE_PICTURE: Int = 3

class OnePictureVh(val binding: ListitemTapsViewholder1Binding) : RecyclerView.ViewHolder(binding.root){

    fun bind(data: Data){
        binding.news = data

        //数据改变立即刷新界面
        binding.executePendingBindings()
    }

}

class TwoPictureVh

class ThreePictureVh