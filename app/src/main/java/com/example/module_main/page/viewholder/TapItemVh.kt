package com.example.module_main.page.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.module_main.data.bean.Data
import com.example.module_main.databinding.ListitemTapsViewholder1Binding
import com.example.module_main.databinding.ListitemTapsViewholder2Binding
import com.example.module_main.databinding.ListitemTapsViewholder3Binding
import com.example.module_main.event.fragment.RvTapsAdapterListener

const val TYPE_VIEWHOLDER_ONE_PICTURE: Int = 0
const val TYPE_VIEWHOLDER_TWO_PICTURE: Int = 1
const val TYPE_VIEWHOLDER_THREE_PICTURE: Int = 2

class OnePictureVh(val binding: ListitemTapsViewholder1Binding) : RecyclerView.ViewHolder(binding.root){

    fun bind(data: Data, listener: RvTapsAdapterListener){
        binding.news = data
        binding.listener = listener

        //数据改变立即刷新界面
        binding.executePendingBindings()
    }

}

class TwoPictureVh(val binding: ListitemTapsViewholder2Binding): RecyclerView.ViewHolder(binding.root){
    fun bind(data: Data){
        binding.news2 = data

        //数据改变立即刷新界面
        binding.executePendingBindings()
    }
}

class ThreePictureVh(val binding: ListitemTapsViewholder3Binding): RecyclerView.ViewHolder(binding.root){
    fun bind(data: Data){
        binding.news3 = data

        //数据改变立即刷新界面
        binding.executePendingBindings()
    }
}