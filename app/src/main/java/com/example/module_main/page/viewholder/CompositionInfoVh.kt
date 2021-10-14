package com.example.module_main.page.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.module_main.data.bean.CompositionInfo
import com.example.module_main.databinding.ListitemPositionBinding

class CompositionInfoVh(private val binding: ListitemPositionBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(compositionInfo: CompositionInfo){
        binding.compositionInfo = compositionInfo
        binding.executePendingBindings()
    }
}
